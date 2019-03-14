
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ConverterFrame extends JInternalFrame implements
        ActionListener
{

    private JTextField feetText = new JTextField(5);
    private JTextField inchesText = new JTextField(5);
    private JRadioButton feetRB = new JRadioButton("Feet");
    private JRadioButton inchesRB = new JRadioButton("Inches");
    private JButton calcButon = new JButton("Convert");
    String title;

    public ConverterFrame(String title)
    {

        super(title, true, true);
        this.title = title;

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3, 1));
        JPanel tempPanel = new JPanel();
        tempPanel.add(new JLabel("Convert From: "));
        tempPanel.add(inchesRB);
        tempPanel.add(feetRB);
        contentPane.add(tempPanel, 0, 0);
        tempPanel = new JPanel();
        tempPanel.add(new JLabel("Inches "));
        tempPanel.add(inchesText);
        tempPanel.add(calcButon);
        tempPanel.add(new JLabel("Feet "));
        tempPanel.add(feetText);
        feetText.setEditable(false);
        contentPane.add(tempPanel, 0, 1);
        ButtonGroup group = new ButtonGroup();
        group.add(feetRB);        
        group.add(inchesRB);
        inchesRB.setSelected(true);
        calcButon.addActionListener(this);
        inchesRB.addActionListener(this);
        feetRB.addActionListener(this);        

    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == calcButon) {
            //Clicking the convert button should take whatever is in the editable
            //text box and convert it to feet or inches, as appropriate 
            try {
                

                if (inchesRB.isSelected()) {
                    double inches = Double.parseDouble(inchesText.getText());
                    feetText.setText(String.format("%.2f", 1.0 / 12.0 * inches));

                } else {
                    double feet = Double.parseDouble(feetText.getText());
                    inchesText.setText(String.format("%.2f", 12.0 * feet));

                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid value!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(inchesRB.isSelected())//Selecting a radio button will change which text field is editable
        {
            inchesText.setEditable(true);
            feetText.setEditable(false);            
        }
        else if(feetRB.isSelected())
        {
            inchesText.setEditable(false);
            feetText.setEditable(true);            
        }
    }
}

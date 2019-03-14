
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


/**
 *
 * @author User
 */
class DesktopFrame extends JFrame
{

    //Should contain a JDesktopPane on which to put the windows that will open 
    private JDesktopPane desktopPane;

    public DesktopFrame()
    {
        super("Homework 5");
        JMenuBar bar = new JMenuBar();
        JMenu addMenu = new JMenu("Create");
        JMenuItem pictureFrame = new JMenuItem("Picture Frame");
        addMenu.add(pictureFrame);
        pictureFrame.setMnemonic('P');//This menu option should be accessible by the mnemonic ’p’

        JMenuItem addConverter = new JMenuItem("Converter Frame");
        addMenu.add(addConverter);
        addConverter.setMnemonic('C');
        bar.add(addMenu);
        //The second menu, “Quit”, will contain a single item ”Exit Program”
        //that will close the program

        JMenu exitMenu = new JMenu("Quit");
        exitMenu.setMnemonic('q');
        JMenuItem exitItem = new JMenuItem("Exit program");
        exitItem.setMnemonic('x');
        exitMenu.add(exitItem);
        bar.add(exitMenu);

        setJMenuBar(bar);
        desktopPane = new JDesktopPane();
        add(desktopPane);//to JFrame contentPane

        pictureFrame.addActionListener(new ActionListener()//anonymous class
        {
            public void actionPerformed(ActionEvent e)
            {
                JInternalFrame frame = new JInternalFrame("Picture Frame", true, true, true, true);//child window
                DrawPanel panel = new DrawPanel();
                frame.add(panel, BorderLayout.CENTER);
                frame.pack();
                frame.setBounds(50, 50, 340, 200);   

                desktopPane.add(frame);
                frame.setVisible(true);
            }
        }
        );

        addConverter.addActionListener(new ActionListener()//anonymous class
        {
            public void actionPerformed(ActionEvent e)
            {
                JInternalFrame frame = new ConverterFrame("Converter Frame");
                desktopPane.add(frame);
                frame.setBounds(200, 50, 340, 200);                
                frame.setVisible(true);
            }
        }
        );
        exitItem.addActionListener(new ActionListener()//anonymous class
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        }
        );
    } 
}

class DrawPanel extends JPanel
{

    public DrawPanel()
    {
          setBackground(Color.BLUE);  
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.yellow);
        //The circle should be yellow, have a width and height of 25% of the
        //frame’s width or height (whichever is smaller at the time of painting),
        //and be placed at a default position 10% from the top of the frame
        //and 30% from the right of the frame.
        int circleDiameter=Math.min(getHeight(),getWidth())*25/100;
        g.fillOval((int) (getWidth() * 0.7),  (getHeight() *1 /10),circleDiameter,circleDiameter);        
        g.setColor(new Color(156, 93, 82));
        g.fillRect(0,(getHeight()*9)/10, getWidth(), getHeight()/10);
    }    
}

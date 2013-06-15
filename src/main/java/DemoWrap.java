//http://easyjavatutorial.weebly.com/the-jtextfield.html

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Swing windows to wrap around demonstration
 * @author Lianne Meah
 */
public class DemoWrap extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // invoke later to stop hanging
            public void run() {
                DemoWrap dm = new DemoWrap();
                dm.setVisible(true);
            }
        });
    }
    
    public DemoWrap() {
        init(); // GUI creating within own method; good practice apparently
    }
    
    public final void init() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setLayout(new GridLayout(6, 3, 5, 5));
        //getContentPane().add(panel);
        //panel.setLayout(null);
        
           String[] buttons = {
            "Cls", "Bck", "Close", "", "8", "9", "/", "4",
            "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"
        };

           JButton button = new JButton("Exit");
           panel.add(button);

        for (int i = 0; i < buttons.length; i++) {
            panel.add(new JButton(buttons[i]));
        }

        add(panel);

        setTitle("GridLayout");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        /*JButton button = new JButton("Exit");
        //button.setBounds(50, 60, 80, 30);
        button.setToolTipText("Exit the Program");
        // make the system do something when button is pressed
        button.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               System.out.println("Quitting...");
               System.exit(0);
          }
       });
        
       JButton connectButton = new JButton("Connect");
        //connectButton.setBounds(100,10,130,30);
        connectButton.setToolTipText("Type in the robot's IP address, then click here");
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //MAKE CONNECTIONS HERE
            }
        });

        panel.add(button);
        panel.add(connectButton);
        setTitle("Zeno Panel");
        setSize(400,400);
        setLocationRelativeTo(null); // centres the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);*/
    }
}
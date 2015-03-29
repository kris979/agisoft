/* 
 * ============================================================================ 
 * Name      : PractiseSwing.java
 * Part of     :  NEON
 * 
 * Copyright (c) 2007-2011 Nokia.  All rights reserved.
 * This material, including documentation and any related computer
 * programs, is protected by copyright controlled by Nokia.  All
 * rights are reserved.  Copying, including reproducing, storing,
 * adapting or translating, any or all of this material requires the
 * prior written consent of Nokia.  This material also contains
 * confidential information which may not be disclosed to others
 * without the prior written consent of Nokia.
 * 
 * ============================================================================
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PractiseSwing extends JFrame {

    public PractiseSwing() {
       setTitle("Simple example");
       setSize(500, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);

       JPanel panel = new JPanel();
       getContentPane().add(panel);

       panel.setLayout(null);

       JButton quitButton = new JButton("Quit");
       quitButton.setBounds(50, 60, 80, 30);
       quitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               System.exit(0);
          }
       });

       panel.add(quitButton);


       
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PractiseSwing ex = new PractiseSwing();
                ex.setVisible(true);
            }
        });
    }
}

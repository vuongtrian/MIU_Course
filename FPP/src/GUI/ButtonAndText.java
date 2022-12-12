package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAndText {
    public static void main(String[] args) {
        ButtonAndText();
    }

    static void ButtonAndText() {
        JFrame f = new JFrame("Button Example");
        // Text field
        JTextField tf = new JTextField();
        tf.setBounds(50,50, 150,20);
        // Button
        JButton b = new JButton("Click here");
        b.setBounds(50,100,95,30);
        // Button event
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("Welcome to Javapoint");
            }
        });

        f.add(b);f.add(tf);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
}

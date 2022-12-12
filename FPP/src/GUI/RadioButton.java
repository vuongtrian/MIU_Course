package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButton {
    public static void main(String[] args) {
        new RadioButtonExample();
    }
}

class RadioButtonExample extends JFrame implements ActionListener {
    JRadioButton rb1, rb2, rb3, rb4;
    JButton b;

    RadioButtonExample() {
        rb1 = new JRadioButton("Male");
        rb1.setBounds(100, 50, 100, 30);
        rb2 = new JRadioButton("Female");
        rb2.setBounds(100, 100, 100, 30);
        rb3 = new JRadioButton("FPP");
        rb3.setBounds(100, 150, 100, 30);
        rb4 = new JRadioButton("MPP");
        rb4.setBounds(100, 200, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        ButtonGroup bg2 = new ButtonGroup();
        bg.add(rb1);bg.add(rb2);bg2.add(rb3);bg2.add(rb4);
        b = new JButton("click");
        b.setBounds(100, 250, 80, 30);
        b.addActionListener(this);
        add(rb1);add(rb2);add(b);add(rb3);add(rb4);
        setSize(300, 300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (rb1.isSelected()) {
            JOptionPane.showMessageDialog(this, "You are Male.");
        }
        if (rb2.isSelected()) {
            JOptionPane.showMessageDialog(this, "You are Female.");
        }
    }
}


package MidTermReview;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_MassIndex {
    public static void main(String[] args) {
        new MassIndex();
    }
}

class MassIndex extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField tf1, tf2;
    JButton b;

    MassIndex() {
        l1 = new JLabel("Your mass (Pounds):");
        l1.setBounds(50, 50, 100, 20);
        tf1 = new JTextField();
        tf1.setBounds(50, 100, 100, 20);
        l2 = new JLabel("Your height (Inches): ");
        l2.setBounds(50, 150, 100,20);
        tf2 = new JTextField();
        tf2.setBounds(50, 200, 100,20);

        b = new JButton("Calculate BMI");
        b.setBounds(50, 250, 50,20);
        b.addActionListener(this);

        add(l1); add(tf1); add(l2); add(tf2); add(b);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String massStr = tf1.getText();
        String heightStr = tf2.getText();
        float massFloat = Float.parseFloat(massStr);
        float heightFloat = Float.parseFloat(heightStr);
        float bmi = (massFloat / heightFloat*heightFloat) * 703;
        JOptionPane.showMessageDialog(this, "You BMI is: " + bmi);
    }
}

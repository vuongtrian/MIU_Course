package GUI;

import javax.swing.*;

public class Label {
    public static void main(String[] args) {
        label();
    }

    static void label() {
        JFrame f = new JFrame("Label");

        JLabel l = new JLabel("This is label");
        l.setBounds(50,50,100,30);

        f.add(l);
        f.setSize(300,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


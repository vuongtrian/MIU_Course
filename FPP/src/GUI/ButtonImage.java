package GUI;

import javax.swing.*;

public class ButtonImage {
    public static void main(String[] args) {
        ButtonImage("something.jpg");
    }

    static void ButtonImage(String ImgName) {
        JFrame f = new JFrame("Button Image");

        JButton b = new JButton(new ImageIcon(ImgName));

        b.setBounds(50,100,95,30);
        f.add(b);
        f.setSize(300,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}



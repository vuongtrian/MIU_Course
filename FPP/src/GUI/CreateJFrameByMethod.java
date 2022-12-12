package GUI;

import javax.swing.*;

public class CreateJFrameByMethod {
    public static void main(String[] args) {

        WindowMethod();
    }

    static void WindowMethod() {
        JFrame f = new JFrame();
        f.setSize(400,500);
        f.setLayout(null);

        JButton b = new JButton("Click me");
        b.setBounds(130,100,100, 40);

        f.add(b);
        f.setVisible(true);
    }
}

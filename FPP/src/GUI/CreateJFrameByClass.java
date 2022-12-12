package GUI;

import javax.swing.*;

public class CreateJFrameByClass {
    public static void main(String[] args) {
        new WindowClass();
    }
}

class WindowClass extends JFrame {
    WindowClass() {
        JButton b = new JButton("Click me");
        b.setBounds(130,100,100, 40);

        add(b);
        setSize(400,500);
        setLayout(null);
        setVisible(true);
    }
}


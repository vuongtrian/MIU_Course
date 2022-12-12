package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerByClass {
    public static void main(String[] args) {
        new LabelExample();
    }
}

class LabelExample extends JFrame implements ActionListener{
    JTextField tf;
    JLabel l;
    JButton b;

    LabelExample() {
        tf = new JTextField();
        tf.setBounds(50,50, 150,20);
        l = new JLabel();
        l.setBounds(50,100, 400,20);
        b = new JButton("Find IP");
        b.setBounds(50,150,95,30);
        b.addActionListener(this);
        add(l); add(b);
        setSize(400,400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String host = tf.getText();
            String ip=java.net.InetAddress.getByName(host).getHostAddress();
            l.setText("IP of " + host + " is: " + ip);
        } catch (Exception ex) {
            l.setText(ex.toString());
        }
    }
}

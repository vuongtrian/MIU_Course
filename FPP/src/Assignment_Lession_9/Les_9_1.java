package Assignment_Lession_9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Les_9_1 {
    public static void main(String[] args) {
        new TranslateText();
    }
}

class TranslateText extends JFrame implements ActionListener {
    JLabel l;
    JTextField input, output;
    JButton b;

    TranslateText() {
        l = new JLabel("Input text:");
        l.setBounds(10, 50, 150, 50);
        input = new JTextField();
        input.setBounds(10, 100, 150, 50);
        b = new JButton("Click To Translate");
        b.setBounds(10, 150, 150, 50);
        b.addActionListener(this);
        output = new JTextField();
        output.setBounds(10, 200, 150, 50);

        add(l); add(input); add(b); add(output);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputText = input.getText();
        String outputText = "";

        if (inputText.charAt(0) == 'u' || inputText.charAt(0) == 'e' || inputText.charAt(0) == 'o' || inputText.charAt(0) == 'a' || inputText.charAt(0) == 'i') {
            outputText = inputText + "way";
        } else {
            outputText = inputText.substring(1) + inputText.charAt(0) + "ay";
        }
        output.setText(outputText);
    }
}

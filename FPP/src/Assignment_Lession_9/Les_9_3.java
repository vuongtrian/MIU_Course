package Assignment_Lession_9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Les_9_3 {
    public static void main(String[] args) {
        new Calculator();
//        String str = "123+32";
//        System.out.println(str.indexOf("/"));

    }
}

class Calculator extends JFrame implements ActionListener {
    JTextField tf1, tf2;
    JLabel result, operand;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, point, add, sub, mul, dev, ope, res, cle;

    Calculator() {
        operand = new JLabel("Operand");
        operand.setBounds(10, 20, 100, 40);

        tf1 = new JTextField();
        tf1.setEnabled(false);
        tf1.setBounds(120, 20, 200, 30);

        result = new JLabel("Result");
        result.setBounds(10, 60, 100, 40);

        tf2 = new JTextField();
        tf2.setEnabled(false);
        tf2.setBounds(120, 60, 200, 30);

        b0 = new JButton("0");
        b0.setBounds(10, 100, 30, 30);
        b0.addActionListener(this);
        b1 = new JButton("1");
        b1.setBounds(50, 100, 30, 30);
        b1.addActionListener(this);
        b2 = new JButton("2");
        b2.setBounds(90, 100, 30, 30);
        b2.addActionListener(this);
        b3 = new JButton("3");
        b3.setBounds(130, 100, 30, 30);
        b3.addActionListener(this);
        b4 = new JButton("4");
        b4.setBounds(170, 100, 30, 30);
        b4.addActionListener(this);
        b5 = new JButton("5");
        b5.setBounds(210, 100, 30, 30);
        b5.addActionListener(this);
        b6 = new JButton("6");
        b6.setBounds(250, 100, 30, 30);
        b6.addActionListener(this);
        b7 = new JButton("7");
        b7.setBounds(290, 100, 30, 30);
        b7.addActionListener(this);
        b8 = new JButton("8");
        b8.setBounds(330, 100, 30, 30);
        b8.addActionListener(this);
        b9 = new JButton("9");
        b9.setBounds(370, 100, 30, 30);
        b9.addActionListener(this);

        point = new JButton(".");
        point.setBounds(10, 140, 30, 30);
        point.addActionListener(this);
        add = new JButton("+");
        add.setBounds(50, 140, 30, 30);
        add.addActionListener(this);
        sub = new JButton("-");
        sub.setBounds(90, 140, 30, 30);
        sub.addActionListener(this);
        mul = new JButton("x");
        mul.setBounds(130, 140, 30, 30);
        mul.addActionListener(this);
        dev = new JButton("/");
        dev.setBounds(170, 140, 30, 30);
        dev.addActionListener(this);

        ope = new JButton("=");
        ope.setBounds(10, 180, 50, 50);
        ope.addActionListener(this);
        res = new JButton("Reset");
        res.setBounds(70, 180, 50, 50);
        res.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf2.setText("0.0");
            }
        });
        cle = new JButton("Clear");
        cle.setBounds(130, 180, 50, 50);
        cle.addActionListener(this);

        add(operand);
        add(tf1);
        add(result);
        add(tf2);
        add(b0);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(point);
        add(add);
        add(sub);
        add(mul);
        add(dev);
        add(ope);
        add(res);
        add(cle);
        setSize(1000, 1000);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    String operandStr = "";
    double num1 = 0;
    double num2 = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        operandStr += getTextFromUser(b0, e);
        operandStr += getTextFromUser(b1, e);
        operandStr += getTextFromUser(b2, e);
        operandStr += getTextFromUser(b3, e);
        operandStr += getTextFromUser(b4, e);
        operandStr += getTextFromUser(b5, e);
        operandStr += getTextFromUser(b6, e);
        operandStr += getTextFromUser(b7, e);
        operandStr += getTextFromUser(b8, e);
        operandStr += getTextFromUser(b9, e);
        operandStr += getTextFromUser(add, e);
        operandStr += getTextFromUser(sub, e);
        operandStr += getTextFromUser(mul, e);
        operandStr += getTextFromUser(dev, e);

        if(e.getSource() == point) {
            if(operandStr.equals("")) {
                operandStr += "0.";
            } else {
                operandStr += point.getText();
            }
        }


        tf1.setText(operandStr);

        if (e.getSource() == ope) {
            String temp = operandStr;
            int pos = -1;
            if (temp.contains("+")) {
                pos = temp.indexOf("+");
                String num_1_Str = temp.substring(0,pos);
                num1 = Double.valueOf(num_1_Str);
                String num_2_Str = temp.substring(pos+1, temp.length());
                num2 = Double.valueOf(num_2_Str);
                Double res = num1 + num2;
                tf2.setText(String.valueOf(res));
            } else if(temp.contains("-")) {
                pos = temp.indexOf("-");
                String num_1_Str = temp.substring(0,pos);
                num1 = Double.valueOf(num_1_Str);
                String num_2_Str = temp.substring(pos+1, temp.length());
                num2 = Double.valueOf(num_2_Str);
                Double res = num1 - num2;
                tf2.setText(String.valueOf(res));
            } else if (temp.contains("x")) {
                pos = temp.indexOf("x");
                String num_1_Str = temp.substring(0,pos);
                num1 = Double.valueOf(num_1_Str);
                String num_2_Str = temp.substring(pos+1, temp.length());
                num2 = Double.valueOf(num_2_Str);
                Double res = num1 * num2;
                tf2.setText(String.valueOf(res));
            } else if (temp.contains("/")) {
                pos = temp.indexOf("x");
                String num_1_Str = temp.substring(0,pos);
                num1 = Double.valueOf(num_1_Str);
                String num_2_Str = temp.substring(pos+1, temp.length());
                num2 = Double.valueOf(num_2_Str);
                Double res = num1 / num2;
                tf2.setText(String.valueOf(res));
            } else {
                tf2.setText(temp);
            }
        }

        if(e.getSource() == cle) {
            operandStr = "";
            tf1.setText("");
        }
    }


    public String getTextFromUser(JButton b, ActionEvent e) {
        String str = "";
        if (e.getSource() == b) {
            str += b.getText();
        }
        return str;
    }

}

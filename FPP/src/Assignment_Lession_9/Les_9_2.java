package Assignment_Lession_9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Les_9_2 {
    public static void main(String[] args) {
        new NumberGame();
    }
}

class NumberGame extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
    JTextField output;

    int count = 0;
    int countOdd = 0;
    int[] randomArr = new int[9];

    NumberGame() {
        for (int i = 0; i < randomArr.length; i++) {
            int num = 1 + (int) (Math.random() * ((50 - 1) + 1));
            randomArr[i] = num;
        }
        System.out.println(Arrays.toString(randomArr));


        b1 = new JButton("Number");
        b1.setBounds(10, 100, 100, 30);
        b1.addActionListener(this);
        b2 = new JButton("Number");
        b2.setBounds(110, 100, 100, 30);
        b2.addActionListener(this);
        b3 = new JButton("Number");
        b3.setBounds(210, 100, 100, 30);
        b3.addActionListener(this);
        b4 = new JButton("Number");
        b4.setBounds(310, 100, 100, 30);
        b4.addActionListener(this);
        b5 = new JButton("Number");
        b5.setBounds(410, 100, 100, 30);
        b5.addActionListener(this);
        b6 = new JButton("Number");
        b6.setBounds(510, 100, 100, 30);
        b6.addActionListener(this);
        b7 = new JButton("Number");
        b7.setBounds(610, 100, 100, 30);
        b7.addActionListener(this);
        b8 = new JButton("Number");
        b8.setBounds(710, 100, 100, 30);
        b8.addActionListener(this);
        b9 = new JButton("Number");
        b9.setBounds(810, 100, 100, 30);
        b9.addActionListener(this);

        output = new JTextField();
        output.setBounds(10, 150, 300, 30);


        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(output);
        setSize(1000, 300);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public boolean checkSpecialCase(JButton b, int num) {
        if (num == 50) {
            output.setText("You got bumper prize of $1000");
            return true;
        } else if (num % 2 == 0) {
            output.setText("Better Luck Next Time!");
            return true;
        } else {
            b.setText(String.valueOf(num));
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (!checkSpecialCase(b1, randomArr[0])) {
                countOdd++;
            }
            count++;
        } else if (e.getSource() == b2) {

            if (!checkSpecialCase(b2, randomArr[1])) {
                countOdd++;
            }
            count++;
        } else if (e.getSource() == b3) {
            if (!checkSpecialCase(b3, randomArr[2])) {
                countOdd++;
            }
            count++;
        } else if (e.getSource() == b4) {
            if (!checkSpecialCase(b4, randomArr[3])) {
               countOdd++;
            }
            count++;
        } else if (e.getSource() == b5) {
            if (!checkSpecialCase(b5, randomArr[4])) {
                countOdd++;
            }
            count++;
        } else if (e.getSource() == b6) {
            if (!checkSpecialCase(b6, randomArr[5])) {
                countOdd++;
            }
            count++;
        } else if (e.getSource() == b7) {
            if (!checkSpecialCase(b7, randomArr[6])) {
                countOdd++;
            }
            count++;
        } else if (e.getSource() == b8) {
            if (!checkSpecialCase(b8, randomArr[7])) {
                countOdd++;
            }
            count++;
        } else if (e.getSource() == b9) {
            if (!checkSpecialCase(b9, randomArr[8])) {
                countOdd++;
            }
            count++;
        }
        if(count >= 3) {
            if (countOdd == 1) {
                output.setText("You got a prize $20");
            } else if (countOdd == 2) {
                output.setText("You got a prize $50");
            } else if (countOdd == 3) {
                output.setText("You got a prize $100");
            }
            return;
        }
    }
}

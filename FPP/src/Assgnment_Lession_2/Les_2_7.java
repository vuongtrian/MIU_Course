package Assgnment_Lession_2;

import java.util.Random;

public class Les_2_7 {

    public static void main(String[] args) {
        float[] temperatures = new float[365];


        for (int i = 0; i < 365; i++) {
            temperatures[i] = -100 + (float)Math.random() * 200;
        }

        float hottest = temperatures[0];
        float coldest = temperatures[0];
        for (float t : temperatures) {
            if(t > hottest) {
                hottest = t;
            } else if (t < coldest) {
                coldest = t;
            }
        }

        System.out.println("Hottest temperature: " + hottest);
        System.out.println("Coldest temperature: " + coldest);
    }
}
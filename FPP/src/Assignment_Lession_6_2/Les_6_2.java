package Assignment_Lession_6_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Les_6_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pet> list = new ArrayList<>();

        boolean temp = true;
        while (temp) {
            System.out.println("Enter a name: ");
            String name = sc.nextLine();
            if (name.equals("STOP")) {
                temp = false;
                break;
            }
            System.out.println("Enter c for cat and d for dog");
            String type = sc.nextLine();
            switch (type) {
                case "c":
                    Pet cat = new Cat(name);
                    list.add(cat);
                    break;
                case "d":
                    Pet dog = new Dog(name);
                    list.add(dog);
                    break;
                default:
                    System.out.println("Invalid name. Please input again");
            }
        }

        for (Pet p: list) {
            if (p instanceof Cat) {
                System.out.println("Name: " + p.getName() + " - Type: Cat" );
            }
        }
        for (Pet p: list) {
            if (p instanceof Dog) {
                System.out.println("Name: " + p.getName() + " - Type: Dog" );
            }
        }
    }
}

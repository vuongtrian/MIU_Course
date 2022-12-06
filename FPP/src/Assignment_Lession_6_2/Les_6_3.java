package Assignment_Lession_6_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Les_6_3 {
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
                    System.out.println("Enter coat color: ");
                    String costColor = sc.nextLine();
                    Pet cat = new Cat_2(name, costColor);
                    list.add(cat);
                    break;
                case "d":
                    System.out.println("Enter the weight: ");
                    int weight = sc.nextInt();
                    sc.nextLine();
                    Pet dog = new Dog_2(name,weight);
                    list.add(dog);
                    break;
                default:
                    System.out.println("Invalid name. Please input again");
            }
        }

        for (Pet p: list) {
            if (p instanceof Cat_2) {
                System.out.println("Name: " + p.getName() + " - Type: Cat - Cost color: " + ((Cat_2) p).getCoat() );
            }
        }
        for (Pet p: list) {
            if (p instanceof Dog_2) {
                System.out.println("Name: " + p.getName() + " - Type: Dog - Weight: " + ((Dog_2) p).getWeight() );
            }
        }
    }
}

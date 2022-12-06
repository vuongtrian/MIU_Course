package Assignment_Lession_6_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Les_6_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pet> list = new ArrayList<>();
        List<Dog_2> listDog = new ArrayList<>();

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
                    listDog.add((Dog_2) dog);
                    break;
                default:
                    System.out.println("Invalid name. Please input again");
            }
        }

        double maxWeight = listDog.get(0).getWeight();
        double minWeight = listDog.get(0).getWeight();
        double sumWeight = 0;
        for (Dog_2 d : listDog) {
            if (d.getWeight() > maxWeight) {
                maxWeight = d.getWeight();
            }

            if (d.getWeight() < minWeight) {
                minWeight = d.getWeight();
            }

            sumWeight += d.getWeight();
        }

        double averageWeight = sumWeight / listDog.size();
        System.out.println("Max weight: " + maxWeight + " - Min weight: " + minWeight + " - Average weight: " + averageWeight);
    }
}

package Assignment_Lession_6_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Les_6_5 {
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
            String input = sc.nextLine();
            switch (input) {
                case "c":
                    Pet cat = new Cat("c");
                    list.add(cat);
                    break;
                case "d":
                    Pet dog = new Dog("d");
                    list.add(dog);
                    break;
                case "STOP":
                    temp = false;
                    break;
                default:
                    System.out.println("Invalid name. Please input again");
            }
        }
        for (Pet p: list) {
            if (p instanceof Cat) {
                System.out.println("Name: " + p.name + " - Type: Cat" );
            } else {
                System.out.println("Name: " + p.name + " - Type: Dog" );
            }
        }
    }
}

class Pet {
    String name;

    public Pet(String name) {
        this.name = name;
    }
}

class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }
}

class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }
}
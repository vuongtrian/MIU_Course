package Assignment_Lession_6_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Les_6_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Dog_2> dogList = new ArrayList<>();
        List<Cat_2> catList = new ArrayList<>();

        boolean temp = true;
        while (temp) {
            System.out.println("Choose number: " +
                    "\n1. Add Cat" +
                    "\n2. Add Dog" +
                    "\n3. Remove Cat" +
                    "\n4. Remove Dog" +
                    "\n0. Quit");
            System.out.println("Enter number: ");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter a name: ");
                    String catName = sc.nextLine();
                    System.out.println("Enter a coat color: ");
                    String coatColor = sc.nextLine();
                    Cat_2 cat = new Cat_2(catName, coatColor);
                    catList.add(cat);
                    break;
                case 2:
                    System.out.println("Enter a name: ");
                    String dogName = sc.nextLine();
                    System.out.println("Enter the weight: ");
                    int weight = sc.nextInt();
                    sc.nextLine();
                    Dog_2 dog = new Dog_2(dogName,weight);
                    dogList.add(dog);
                    break;
                case 3:
                    if (catList == null) {
                        System.out.println("Cat list is empty");
                    } else {
                        System.out.println("Enter a name that you want to remove: ");
                        String removedCatName = sc.nextLine();
                        for (Cat_2 d : catList) {
                            if(d.getName().equals(removedCatName)) {
                                catList.remove(d);
                            }
                        }
//                        catList.removeIf(d -> d.getName().equals(removedCatName));
                    }
                    break;
                case 4:
                    if(dogList == null) {
                        System.out.println("Dog list is empty");
                    } else {
                        System.out.println("Enter a name that you want to remove: ");
                        String removedDogName = sc.nextLine();
                        for (Dog_2 d : dogList) {
                            if(d.getName().equals(removedDogName)){
                                dogList.remove(d);
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("Quiting...");
                    temp = false;
                    break;
                default:
                    System.out.println("Invalid number. Please enter again!");
            }
        }

    }
}

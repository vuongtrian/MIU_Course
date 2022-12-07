package Assignment_Lession_7_1;

public class Main {
    public static void main(String[] args) {
        City fairfield = new City("Fairfield", 70);
        City ames = new City("Ames", 60);
        City desmoines = new City("Des Moines", 80);

        City[] arrCity = {fairfield,ames,desmoines};
        sorting(arrCity);
        for (City c: arrCity) {
            System.out.println("City name: " + c.getCityName() + " - Temperature: " + c.getTemperature());
        }
    }

    public static void sorting (City[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (!arr[i].compareTo(arr[i+1])) {
                City temp = new City();
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    }
}

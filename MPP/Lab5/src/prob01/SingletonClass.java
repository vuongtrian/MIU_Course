package prob01;

public class SingletonClass {
    private static SingletonClass instance = null;

    private SingletonClass() {};

    public static SingletonClass getSingletonObject() {
        if(instance == null) {
            instance = new SingletonClass();
            long key = Math.round(Math.random() * 10000000);
            System.out.println("Key generated Successfull");
            System.out.println("Your key to activate Avast anti virus is:" + key);
        } else {
            System.out.println("Unsuccessful to produce the key....");
        }
        return instance;
    }
}

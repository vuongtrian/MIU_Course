package UpCastingAndDownCasting;

public class TestUpcasting {
    public static void main(String[] args) {
        Parent parent = new Child();
        System.out.println(parent.name);
        parent.print();
        parent.test();
    }

}




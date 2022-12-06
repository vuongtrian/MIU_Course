package UpCastingAndDownCasting;

public class TestDowncating {
    public static void main(String[] args) {
        Parent parent = new Child();
        if (parent instanceof Child) {
            Child child = (Child) parent;
            child.print();
            child.test();
            System.out.println(child.name);
            child.childMethod();
            child.parentMethod();
        }


    }
}

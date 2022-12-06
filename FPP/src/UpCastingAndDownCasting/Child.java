package UpCastingAndDownCasting;

class Child extends Parent {
    String name = "Child";

    public void print() {
        System.out.println("From Child");
    }

    @Override
    public void test() {
        System.out.println("Test from Child");
    }

    public void childMethod() {
        System.out.println("Child method");
    }
}

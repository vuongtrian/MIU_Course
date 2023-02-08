package lesson3.labs.prob1;

public class PersonWithJon {

    private double salary;
    private Person person;

    public PersonWithJon(String n, double s) {
        salary = s;
        person = new Person(n);
    }

    public String getName() {
        return person.getName();
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object aPersonWithJob) {
        if(aPersonWithJob == null) return false;
        if(!(aPersonWithJob instanceof PersonWithJon)) return false;
        PersonWithJon p = (PersonWithJon)aPersonWithJob;
        boolean isEqual = this.getName().equals(p.getName()) && this.getSalary()==p.getSalary();
        return isEqual;
    }

    public static void main(String[] args) {
        PersonWithJon p1 = new PersonWithJon("Joe", 30000);
        Person p2 = new Person("Joe");
        //As PersonsWithJobs, p1 should be equal to p2
        System.out.println("p1.equals(p2)? " + p1.equals(p2));
        System.out.println("p2.equals(p1)? " + p2.equals(p1));
    }
}

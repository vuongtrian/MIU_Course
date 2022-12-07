package Assignment_Lession_7_3;

public class Student implements Comparable {
    private String id;
    private String lastName;

    public Student(String id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public int compareName(Student theStudent) {
        if(lastName.compareTo(theStudent.getLastName()) > 0) {
            return 1;
        }
        return 0;
    }
}

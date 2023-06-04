package cm.sg.ClassRoster.dto;

public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String cohort;

    public Student(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }

    //for testing Dao => right-click on Student Class => Generate => equals & hashCode => Select all 4 checkboxes in both sections
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!firstName.equals(student.firstName)) return false;
        if (!lastName.equals(student.lastName)) return false;
        if (!studentId.equals(student.studentId)) return false;
        return cohort.equals(student.cohort);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + studentId.hashCode();
        result = 31 * result + cohort.hashCode();
        return result;
    }

    //for testing Dao => Adding toString to Student: right-click => Generate => toString()
    //to help with test failure messages.
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", cohort='" + cohort + '\'' +
                '}';
    }
}

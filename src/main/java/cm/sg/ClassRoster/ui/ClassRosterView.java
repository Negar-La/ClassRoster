package cm.sg.ClassRoster.ui;

import cm.sg.ClassRoster.dto.Student;

import java.util.ArrayList;
import java.util.List;

public class ClassRosterView {
    //private UserIO io = new UserIOConsoleImpl();     //1-Remove the hard-coded reference to UserIO in the view.
    private UserIO io;
    public ClassRosterView(UserIO io){                  //2-using the constructor to initialize io
        this.io = io;
    }

          public int printMenuAndGetSelection() {
              io.print("Main Menu");
              io.print("1. List All Students");
              io.print("2. Create New Student");
              io.print("3. View a Student");
              io.print("4. Remove a Student");
              io.print("5. Exit");

             return io.readInt("Please select from the"
                      + " above choices."); //if we remove min and max, then the default case in switch would happen when entering an integer number not between 1-5  = Unknown Command!!!
              //if we enter letter, double, space, empty === 'Input error. Please try again.' which comes from  io.readInt
          }

    public Student getNewStudentInfo() {
        String studentId = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String cohort = io.readString("Please enter Cohort");
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        return currentStudent;
    }

    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "Student successfully created.  Please hit enter to continue");
    }

    public void displayStudentList (List<Student> studentList){
              for(Student currentStudent: studentList){
                  String studentInfo = String.format("#%s : %s %s",
                  currentStudent.getStudentId(),
                  currentStudent.getFirstName(),
                  currentStudent.getLastName());
                  io.print(studentInfo);
                  io.print("========");
              }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }

    public void displayDisplayStudentBanner () {
        io.print("=== Display Student ===");
    }

    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
    }

    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveStudentBanner () {
        io.print("=== Remove Student ===");
    }

    public void displayRemoveResult(Student studentRecord) {
        if(studentRecord != null){
            io.print("Student successfully removed.");
        }else{
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}

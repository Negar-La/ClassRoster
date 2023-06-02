package cm.sg.ClassRoster.controller;

import cm.sg.ClassRoster.dao.ClassRosterDao;
import cm.sg.ClassRoster.dao.ClassRosterDaoException;
import cm.sg.ClassRoster.dao.ClassRosterDaoFileImpl;
import cm.sg.ClassRoster.dto.Student;
import cm.sg.ClassRoster.ui.ClassRosterView;
import cm.sg.ClassRoster.ui.UserIO;
import cm.sg.ClassRoster.ui.UserIOConsoleImpl;

import java.util.List;

public class ClassRosterController {


    // private UserIO io = new UserIOConsoleImpl();         //Step 1: Menu System-----create an object from userIO to raed and accept different data types - access to all public members of userIO
    //At firts I don't have the view yet, which uses an object from io, but at the end, there is no More Usage for io in Controller.

    //private ClassRosterView view = new ClassRosterView(); //after moving menu function to view, we initialize view
    //1- Remove the hard-coded reference
    //private ClassRosterDao dao = new ClassRosterDaoFileImpl();

    private ClassRosterView view;           //2-using the constructor to initialize view and dao
    private ClassRosterDao dao;
    public ClassRosterController(ClassRosterView view, ClassRosterDao dao){
        this.view = view;
        this.dao = dao;
    }
    public void run() throws ClassRosterDaoException {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {               //adding try-catch block at the last step after marshal-unmarshal
            while (keepGoing) {
                menuSelection = view.printMenuAndGetSelection();

            /*                         Moved to View.
            io.print("Main Menu");
            io.print("1. List Student IDs");
            io.print("2. Create New Student");
            io.print("3. View a Student");
            io.print("4. Remove a Student");
            io.print("5. Exit");

            menuSelection = io.readInt("Please select from the"
                    + " above choices.", 1, 5);

             */

                switch (menuSelection) {
                    case 1:
//                    io.print("LIST STUDENTS");
                        listStudents();
                        break;
                    case 2:
//                    io.print("CREATE STUDENT");
                        createStudent();   //make a call to createStudent in the run method
                        break;
                    case 3:
//                    io.print("VIEW STUDENT");
                        viewStudent();
                        break;
                    case 4:
//                    io.print("REMOVE STUDENT");
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
//                    io.print("UNKNOWN COMMAND");          //we cannot use io for the controller!
                        unknownCommand();
                }

            }
//        io.print("GOOD BYE");
            exitMessage();
        } catch (ClassRosterDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
    }


    private void createStudent() throws ClassRosterDaoException {           // private utility function to handle retrieval from different classes
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent); //the DAO stores the newly created Student object for us.
        view.displayCreateSuccessBanner();
    }

    private void listStudents() throws ClassRosterDaoException {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }
    /*
    or you can just add one line to run(): view.displayStudentList(dao.getAllStudents());
    dao method getAllStudents returns a List of Students which we need it as argument in view method displayStudentList.
    Then view.displayStudentList(studentList) loops through the list and prints each student's info.
     */
    private void viewStudent() throws ClassRosterDaoException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();  //get id from view
        Student student = dao.getStudent(studentId);   //based on this id, retrieve the student from dao
        view.displayStudent(student);                  //at the end, display student info
    }

    private void removeStudent() throws ClassRosterDaoException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = dao.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
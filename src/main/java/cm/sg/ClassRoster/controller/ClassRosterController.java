package cm.sg.ClassRoster.controller;

import cm.sg.ClassRoster.ui.ClassRosterView;
import cm.sg.ClassRoster.ui.UserIO;
import cm.sg.ClassRoster.ui.UserIOConsoleImpl;

public class ClassRosterController {


    private UserIO io = new UserIOConsoleImpl(); //Step 1: Menu System-----create an object from userIO to raed and accept different data types - access to all public members of userIO
    //At firts I don't have the view yet, which uses an object from io

    private ClassRosterView view = new ClassRosterView(); //after moving menu function to view, we initialize view
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            menuSelection = view.printMenuAndGetSelection();

            /*
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
                    io.print("LIST STUDENTS");
                    break;
                case 2:
                    io.print("CREATE STUDENT");
                    break;
                case 3:
                    io.print("VIEW STUDENT");
                    break;
                case 4:
                    io.print("REMOVE STUDENT");
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
    }




}
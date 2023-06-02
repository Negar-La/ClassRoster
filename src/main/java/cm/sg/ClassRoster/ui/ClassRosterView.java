package cm.sg.ClassRoster.ui;

public class ClassRosterView {
    private UserIO io = new UserIOConsoleImpl();

          public int printMenuAndGetSelection() {
              io.print("Main Menu");
              io.print("1. List Student IDs");
              io.print("2. Create New Student");
              io.print("3. View a Student");
              io.print("4. Remove a Student");
              io.print("5. Exit");

             return io.readInt("Please select from the"
                      + " above choices.", 1, 5); //if we remove min and max, then the default case in switch would happen.
          }
}

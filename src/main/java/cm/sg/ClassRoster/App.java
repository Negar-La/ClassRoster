package cm.sg.ClassRoster;

import cm.sg.ClassRoster.controller.ClassRosterController;
import cm.sg.ClassRoster.dao.ClassRosterDao;
import cm.sg.ClassRoster.dao.ClassRosterDaoFileImpl;
import cm.sg.ClassRoster.ui.ClassRosterView;
import cm.sg.ClassRoster.ui.UserIO;
import cm.sg.ClassRoster.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
       // ClassRosterController controller = new ClassRosterController();
            // after Dependency Injection in controller and view, we need to fix the app. we cannot use controller default constructor any more, Controller should take view and dao.
        UserIO myIO = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIO);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(myView, myDao);
        controller.run();
    }

}

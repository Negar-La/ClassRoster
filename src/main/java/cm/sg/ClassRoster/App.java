package cm.sg.ClassRoster;

import cm.sg.ClassRoster.controller.ClassRosterController;
import cm.sg.ClassRoster.dao.*;
import cm.sg.ClassRoster.service.ClassRosterServiceLayer;
import cm.sg.ClassRoster.service.ClassRosterServiceLayerImpl;
import cm.sg.ClassRoster.ui.ClassRosterView;
import cm.sg.ClassRoster.ui.UserIO;
import cm.sg.ClassRoster.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) throws ClassRosterPersistenceException {
       // ClassRosterController controller = new ClassRosterController();
            // after Dependency Injection in controller and view, we need to fix the app. we cannot use controller default constructor anymore, Controller should take view and dao.
        UserIO myIO = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIO);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        //ClassRosterController controller = new ClassRosterController(myView, myDao); //Modify the code that instantiates the Controller
        //ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao); //instantiate the Service Layer
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();           // Instantiate the Audit DAO
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao); //re-write myService
        ClassRosterController controller = new ClassRosterController(myView, myService);
        controller.run();
    }

}

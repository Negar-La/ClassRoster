package cm.sg.ClassRoster.dao;

public class ClassRosterPersistenceException extends Exception{  //to handle data access, we can declare our own exceptions to handle errors

//After adding service layer, we renamed  ClassRosterDaoException to ClassRosterPersistenceException to generalize it.

    public ClassRosterPersistenceException(String message) {    //we have two constructors.
        super(message);   //super indicates we retrieve info from super class=Exception = call the matching constructor on the Exception class by calling super
    }

    public ClassRosterPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}

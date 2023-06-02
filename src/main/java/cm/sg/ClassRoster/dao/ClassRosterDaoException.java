package cm.sg.ClassRoster.dao;

public class ClassRosterDaoException extends Exception{  //to handle data access, we can declare our own exceptions to handle errors

    public ClassRosterDaoException(String message) {    //we have two constructors.
        super(message);   //super indicates we retrieve info from super class=Exception = call the matching constructor on the Exception class by calling super
    }

    public ClassRosterDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}

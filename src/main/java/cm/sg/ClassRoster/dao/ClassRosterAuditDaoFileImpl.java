package cm.sg.ClassRoster.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao{
    public static final String AUDIT_FILE = "audit.txt";

    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        PrintWriter out; //create object for PrintWriter

        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true)); //setting the second parameter of the FileWriter constructor to true: each entry will be appended to the file rather than overwriting everything that was there before.
        } catch (IOException e) {
            throw new ClassRosterPersistenceException("Could not persist audit information.", e);
        }

        LocalDateTime timestamp = LocalDateTime.now(); //retrieve current date and time
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
}

package cm.sg.ClassRoster.dao;

import cm.sg.ClassRoster.dto.Student;

import java.io.*;
import java.util.*;

public class ClassRosterDaoFileImpl implements ClassRosterDao{
    private Map<String, Student> students = new HashMap<>();

    //public static final String ROSTER_FILE = "roster.txt";  //File Persistence (declaration and assignment)----
    //after starting Dao testing, we remove the keyword static from ROSTER-FILE and then using 2 constructors
    private final String ROSTER_FILE; //it exists as a declaration, not a declaration and assignment
    public ClassRosterDaoFileImpl(){  // The first, no-args constructor is providing the earlier default behavior = production data
        ROSTER_FILE = "roster.txt";
    }
    public ClassRosterDaoFileImpl(String rosterTextFile){ // the second overloaded constructor creates an instances that utilize another file, perfect for test setup
        ROSTER_FILE = rosterTextFile;
    }
    public static final String DELIMITER = "::";


    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {
        //do the actual implementation here:
        /*
        Student prevStudent = students.put(studentId, student);
        return prevStudent;
         */
        //update method to write into the file!
            loadRoster();
        Student newStudent = students.put(studentId, student);
            writeRoster();
        return newStudent;
    }

    @Override
    public Student removeStudent(String StudentId) throws ClassRosterPersistenceException {
        loadRoster();
        Student removedStudent = students.remove(StudentId);
        writeRoster();
        return removedStudent;
    }

    @Override
    public Student getStudent(String StudentId) throws ClassRosterPersistenceException {
            loadRoster(); //adding this line to read from the file
        return students.get(StudentId);
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
            loadRoster();  //adding this line to read from the file
        List<Student> x = new ArrayList<>(students.values()); //because we declared students as HashMap
       return x;
    }

    //unmarshall Student =  translate a line of text into a Student object.
    private Student unmarshallStudent(String studentAsText){
        String[] studentTokens = studentAsText.split(DELIMITER);
        String studentId = studentTokens[0];
        Student studentFromFile = new Student(studentId);
        studentFromFile.setFirstName(studentTokens[1]);
        studentFromFile.setLastName(studentTokens[2]);
        studentFromFile.setCohort(studentTokens[3]);
        return studentFromFile;
    }

    private void loadRoster() throws ClassRosterPersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;
        Student currentStudent;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentStudent = unmarshallStudent(currentLine);
            // Put currentStudent into the map using student id as the key
            students.put(currentStudent.getStudentId(), currentStudent);
        }
        scanner.close();
    }

    // We need to turn a Student object into a line of text for our file.
    private String marshallStudent(Student aStudent){
        // Start with the student id, since that's supposed to be first.
        String studentAsText = aStudent.getStudentId() + DELIMITER;

        // add the rest of the properties in the correct order:

        // FirstName
        studentAsText += aStudent.getFirstName() + DELIMITER;

        // LastName
        studentAsText += aStudent.getLastName() + DELIMITER;

        // Cohort - don't forget to skip the DELIMITER here.
        studentAsText += aStudent.getCohort();

        // We have now turned a student to text! Return it!
        return studentAsText;
    }


    private void writeRoster() throws ClassRosterPersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException(
                    "Could not save student data.", e);
        }
        String studentAsText;
        List<Student> studentList = this.getAllStudents();
        for (Student currentStudent : studentList) {
            // turn a Student into a String
            studentAsText = marshallStudent(currentStudent);
            // write the Student object to the file
            out.println(studentAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

}

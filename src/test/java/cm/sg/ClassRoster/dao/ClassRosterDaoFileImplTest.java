package cm.sg.ClassRoster.dao;

import cm.sg.ClassRoster.dto.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassRosterDaoFileImplTest {
    //in ClassRosterDaoFileImpl right-click => Generate => Test... => JUnit5 => selecting setUp/@Before
    //it creates test -> Java -> cm.sg.ClassRoster.dao package!
    ClassRosterDao testDao;     //to connect this class with ClassRosterDao
    @BeforeEach
    public void setUp() throws Exception{// It can be used to set things to a known good state before each test.
        String testFile = "testroster.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new ClassRosterDaoFileImpl(testFile);
    }

    @Test
    public void testAddGetStudent() throws Exception {
        // Create our Student
        String studentId = "0001";
        Student student = new Student(studentId);
        student.setFirstName("Ada");
        student.setLastName("Lovelace");
        student.setCohort("Java-May-1845");

        //  Add the student to the DAO
        testDao.addStudent(studentId, student);
        // Get the student from the DAO
        Student retrievedStudent = testDao.getStudent(studentId);

        // Check the data is equal
        assertEquals(student.getStudentId(),
                retrievedStudent.getStudentId(),
                "Checking student id.");
        assertEquals(student.getFirstName(),
                retrievedStudent.getFirstName(),
                "Checking student first name.");
        assertEquals(student.getLastName(),
                retrievedStudent.getLastName(),
                "Checking student last name.");
        assertEquals(student.getCohort(),
                retrievedStudent.getCohort(),
                "Checking student cohort.");
    }

    @Test
    public void testAddGetAllStudents() throws Exception {
        // Create our first student
        Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java-May-1845");

        // Create our second student
        Student secondStudent = new Student("0002");
        secondStudent.setFirstName("Charles");
        secondStudent.setLastName("Babbage");
        secondStudent.setCohort(".NET-May-1845");

        // Add both our students to the DAO
        testDao.addStudent(firstStudent.getStudentId(), firstStudent);
        testDao.addStudent(secondStudent.getStudentId(), secondStudent);

        // Retrieve the list of all students within the DAO
        List<Student> allStudents = testDao.getAllStudents();

        // First check the general contents of the list
        assertNotNull(allStudents, "The list of students must not null");
        assertEquals(2, allStudents.size(),"List of students should have 2 students.");

        // Then the specifics
        assertTrue(testDao.getAllStudents().contains(firstStudent),
                "The list of students should include Ada.");
        assertTrue(testDao.getAllStudents().contains(secondStudent),
                "The list of students should include Charles.");
    }

    @Test
    public void testRemoveStudent() throws Exception {
        // Create two new students
        Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java-May-1945");

        Student secondStudent = new Student("0002");
        secondStudent.setFirstName("Charles");
        secondStudent.setLastName("Babbage");
        secondStudent.setCohort(".NET-May-1945");

        // Add both to the DAO
        testDao.addStudent(firstStudent.getStudentId(), firstStudent);
        testDao.addStudent(secondStudent.getStudentId(), secondStudent);

        // remove the first student - Ada
        Student removedStudent = testDao.removeStudent(firstStudent.getStudentId());

        // Check that the correct object was removed.
        assertEquals(removedStudent, firstStudent, "The removed student should be Ada.");

        // Get all the students
        List<Student> allStudents = testDao.getAllStudents();

        // First check the general contents of the list
        assertNotNull( allStudents, "All students list should be not null.");
        assertEquals( 1, allStudents.size(), "All students should only have 1 student.");

        // Then the specifics
        assertFalse( allStudents.contains(firstStudent), "All students should NOT include Ada.");
        assertTrue( allStudents.contains(secondStudent), "All students should NOT include Charles.");

        // Remove the second student
        removedStudent = testDao.removeStudent(secondStudent.getStudentId());
        // Check that the correct object was removed.
        assertEquals( removedStudent, secondStudent, "The removed student should be Charles.");

        // retrieve all of the students again, and check the list.
        allStudents = testDao.getAllStudents();

        // Check the contents of the list - it should be empty
        assertTrue( allStudents.isEmpty(), "The retrieved list of students should be empty.");

        // Try to 'get' both students by their old id - they should be null!
        Student retrievedStudent = testDao.getStudent(firstStudent.getStudentId());
        assertNull(retrievedStudent, "Ada was removed, should be null.");

        retrievedStudent = testDao.getStudent(secondStudent.getStudentId());
        assertNull(retrievedStudent, "Charles was removed, should be null.");

    }
}
package cm.sg.ClassRoster.service;

import cm.sg.ClassRoster.dao.ClassRosterDao;
import cm.sg.ClassRoster.dao.ClassRosterPersistenceException;
import cm.sg.ClassRoster.dto.Student;

import java.util.ArrayList;
import java.util.List;

public class ClassRosterDaoStubImpl implements ClassRosterDao {
    //It is not necessary for the DAOs to actually read from and write to files when testing the Service Layer so we'll replace the File Implementations
    // with Stub Implementations containing canned data.
    //we need to test methods from Dao: add/remove/get/getAll considering the business rules.

    public Student onlyStudent;

    public ClassRosterDaoStubImpl() {
        onlyStudent = new Student("0001");
        onlyStudent.setFirstName("Ada");
        onlyStudent.setLastName("Lovelace");
        onlyStudent.setCohort("Java-May-1845");
    }
    public ClassRosterDaoStubImpl(Student testStudent){
        this.onlyStudent = testStudent;
    }
    @Override
    public Student addStudent(String StudentId, Student student) throws ClassRosterPersistenceException {
        if (StudentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public Student removeStudent(String StudentId) throws ClassRosterPersistenceException {
        if (StudentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public Student getStudent(String StudentId) throws ClassRosterPersistenceException {
        if (StudentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(onlyStudent);
        return studentList;
    }
}

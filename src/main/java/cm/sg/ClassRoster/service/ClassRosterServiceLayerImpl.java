package cm.sg.ClassRoster.service;

import cm.sg.ClassRoster.dao.ClassRosterDao;
import cm.sg.ClassRoster.dao.ClassRosterPersistenceException;
import cm.sg.ClassRoster.dto.Student;

import java.util.List;

public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer{

    //Dependency Injection
    ClassRosterDao dao;

    public ClassRosterServiceLayerImpl(ClassRosterDao dao) {
        this.dao = dao;
    }
    @Override
    public void createStudent(Student student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException {
        if (dao.getStudent(student.getStudentId()) != null) { // !=null means the id already exists!
            throw new ClassRosterDuplicateIdException(
                    "ERROR: Could not create student.  Student Id "
                            + student.getStudentId()
                            + " already exists");
        }
        validateStudentData(student);
        // We passed all our business rules checks so go ahead
        // and persist the Student object
        dao.addStudent(student.getStudentId(), student);
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return dao.getAllStudents();   // it is a pass-through method, call the getAllStudents method on the DAO
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        return dao.getStudent(studentId);     // it is a pass-through method, call the getStudent method on the DAO
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        return dao.removeStudent(studentId);       //a pass-through method, call the removeStudent method on the DAO
    }

    private void validateStudentData(Student student) throws        //private helper method
            ClassRosterDataValidationException {

        if (student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0) {

            throw new ClassRosterDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }

}

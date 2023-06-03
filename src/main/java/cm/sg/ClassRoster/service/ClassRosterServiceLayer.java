package cm.sg.ClassRoster.service;

import cm.sg.ClassRoster.dao.ClassRosterPersistenceException;
import cm.sg.ClassRoster.dto.Student;

import java.util.List;

public interface ClassRosterServiceLayer {
    void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException;

    List<Student> getAllStudents() throws
            ClassRosterPersistenceException;

    Student getStudent(String studentId) throws
            ClassRosterPersistenceException;

    Student removeStudent(String studentId) throws
            ClassRosterPersistenceException;
}

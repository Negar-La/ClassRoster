package cm.sg.ClassRoster.dao;

import cm.sg.ClassRoster.dto.Student;

import java.util.List;

public interface ClassRosterDao {

    //DAO (Data Access Object) provides methods for performing CRUD (Create, Read, Update, Delete)
    //all methods by default are abstract in interface.


    Student addStudent(String StudentId, Student student);

    Student removeStudent(String StudentId);

    Student getStudent(String StudentId);

    List<Student> getAllStudents();
}

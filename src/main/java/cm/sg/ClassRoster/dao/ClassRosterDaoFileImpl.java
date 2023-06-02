package cm.sg.ClassRoster.dao;

import cm.sg.ClassRoster.dto.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassRosterDaoFileImpl implements ClassRosterDao{
    private Map<String, Student> studentList = new HashMap<>();
    @Override
    public Student addStudent(String studentId, Student student) {
        //do the actual implementation here:

        Student prevStudent = studentList.put(studentId, student);
        return prevStudent;
    }

    @Override
    public Student removeStudent(String StudentId) {
        return null;
    }

    @Override
    public Student ViewStudent(String StudentId) {
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }
}

package cm.sg.ClassRoster.dao;

import cm.sg.ClassRoster.dto.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassRosterDaoFileImpl implements ClassRosterDao{
    private Map<String, Student> students = new HashMap<>();
    @Override
    public Student addStudent(String studentId, Student student) {
        //do the actual implementation here:
        Student prevStudent = students.put(studentId, student);
        return prevStudent;
    }

    @Override
    public Student removeStudent(String StudentId) {
        return students.remove(StudentId);
    }

    @Override
    public Student getStudent(String StudentId) {
        return students.get(StudentId);
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> x = new ArrayList<>(students.values()); //because we declared students as HashMap
       return x;
    }
}

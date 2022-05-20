package assigment01.student;

import java.util.ArrayList;

public interface IStudentInterface {
    ArrayList<Student> list();
    void create(Student student);
    void update(Student student);
    void delete(Student student);
}

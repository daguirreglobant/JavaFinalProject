package university;

import university.teacher.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private final String name;
    private final String classroom;
    private final List<Student> students;
    private Teacher teacher;

    public Course(String name, String classroom) {
        this(name, classroom, null);
    }

    public Course(String name, String classroom, Teacher teacher) {
        this(name, classroom, teacher, new ArrayList<>());
    }

    public Course(String name, String classroom, Teacher teacher, List<Student> students) {
        this.name = name;
        this.classroom = classroom;
        this.students = students;
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public String getName() {
        return name;
    }

    public String getClassroom() {
        return classroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}

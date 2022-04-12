import teacher.Teacher;

import java.util.ArrayList;

public class Course {
    private final String name;
    private final String classroom;
    private Teacher teacher;
    private final ArrayList<Student> students;

    Course(String name, String classroom){
        this(name, classroom, null);
    }

    Course(String name, String classroom, Teacher teacher){
        this(name, classroom, teacher,  new ArrayList<>());
    }

    Course(String name, String classroom, Teacher teacher, ArrayList<Student> students){
        this.name = name;
        this.classroom = classroom;
        this.students = students;
        this.teacher = teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student){
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

    public ArrayList<Student> getStudents() {
        return students;
    }
}

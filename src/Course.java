import teacher.Teacher;

import java.util.ArrayList;

public class Course {
    private String name;
    private String classroom;
    private Teacher teacher;
    private ArrayList<Student> students;

    Course(String name, String classroom){
        this.name = name;
        this.classroom = classroom;
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

package university;

import university.teacher.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {
    static String name = "Globant University";
    private final Map<Integer, Student> students;
    private final Map<String, Course> courses;
    private final List<Teacher> teachers;
    private int totalStudents;

    public University(Map<Integer, Student> students, List<Teacher> teachers) {
        this.students = students;
        this.teachers = teachers;
        this.courses = new HashMap<>();
        this.totalStudents = students.size();
    }

    public static String getName() {
        return name;
    }

    public boolean containsCourse(String courseName) {
        return this.courses.containsKey(courseName);
    }

    public void enrollStudent(Student student, String courseName) {
        Course course = this.courses.get(courseName);
        student.addCourse(course);
        course.addStudent(student);

        if (!this.students.containsKey(student.getId())) {
            this.addNewStudent(student);
        }
    }

    private void addNewStudent(Student student) {
        this.students.put(student.getId(), student);
        this.totalStudents++;
    }

    public void addCourse(Course course, Teacher teacher, int[] students) {
        course.setTeacher(teacher);
        this.addCourse(course);
        String courseName = course.getName();
        for (int studentID : students) {
            this.enrollStudent(this.students.get(studentID), courseName);
        }
    }

    private void addCourse(Course course) {
        this.courses.put(course.getName(), course);
    }

    public List<Teacher> getTeachers() {
        return this.teachers;
    }

    public Student getStudent(int studentID) {
        return this.students.get(studentID);
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses.values());
    }

    public int getTotalStudents() {
        return totalStudents;
    }
}

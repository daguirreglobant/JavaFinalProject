import teacher.Teacher;

import java.util.*;

public class University {
    static String name = "Globant University";
    private final Map <Integer, Student> students;
    private final Map <String, Course> courses;
    private final ArrayList <Teacher> teachers;
    private int totalStudents = 0;

    University(){
        this.students = new HashMap<>();
        this.courses = new HashMap<>();
        this.teachers =  new ArrayList<>();
    }
    public boolean containsCourse(String courseName) {
        return this.courses.containsKey(courseName);
    }

    private void addNewStudent(Student student){
        this.students.put(student.getId(), student);
        this.totalStudents ++;
    }

    public void enrollStudent(Student student, String courseName){
        Course course = this.courses.get(courseName);
        student.addCourse(course);
        course.addStudent(student);

        if (!this.students.containsKey(student.getId())) {
            this.addNewStudent(student);
        }
    }

    public void addTeacher(Teacher teacher){
        this.teachers.add(teacher);
    }

    public void addCourse(Course course){
        this.courses.put(course.getName(), course);
    }

    public void addCourse(Course course, Teacher teacher, int [] students){
        course.setTeacher(teacher);
        this.addCourse(course);
        String courseName = course.getName();
        for(int studentID : students){
            this.enrollStudent(this.students.get(studentID), courseName);
        }
    }

    public ArrayList<Teacher> getTeachers() {
        return this.teachers;
    }

    public ArrayList<Course> getCoursesByStudentID(int studentID){
        return this.students.get(studentID).getCourses();
    }

    public static String getName() {
        return name;
    }

    public ArrayList<Course> getCourses() {
        return new ArrayList<>(courses.values());
    }

    public int getTotalStudents(){
        return totalStudents;
    }
}

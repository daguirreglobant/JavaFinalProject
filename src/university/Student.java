package university;

import java.util.ArrayList;

public class Student {
    private final int id;
    private final String name;
    private final int age;
    private final ArrayList<Course> courses;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }
}

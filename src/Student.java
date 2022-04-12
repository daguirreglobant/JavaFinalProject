import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private int age;
    private ArrayList<Course> courses;

    Student(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }
}

import teacher.Teacher;

public class Course {
    private String name;
    private String classroom;
    private Teacher teacher;

    Course(String name, String classroom){
        this.name = name;
        this.classroom = classroom;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getTeachersName() {
        return this.teacher.getName();
    }
}

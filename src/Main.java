import teacher.FullTimeTeacher;
import teacher.PartTimeTeacher;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Teacher.setBaseSalary(2000); // if you want to change the default salary base.

        FullTimeTeacher teacher1 = new FullTimeTeacher("David", 10);
        PartTimeTeacher teacher2 = new PartTimeTeacher("Pedro", 25);
        ArrayList<String> data = teacher1.getData();
        // printTeacherData(data);
        Course mathCourse = new Course("Math", "A-113");
        mathCourse.setTeacher(teacher1);
        System.out.println(mathCourse.getTeachersName());
    }
    public static void printTeacherData(ArrayList<String> data){
        for (String element: data){
            System.out.println(element);
        }
    }
}

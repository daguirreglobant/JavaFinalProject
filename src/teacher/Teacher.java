package teacher;

import java.util.ArrayList;

public class Teacher {
    protected final String name;
    static float baseSalary = 1000;
    protected float salary;

    Teacher(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static void setBaseSalary(float baseSalary) {
        Teacher.baseSalary = baseSalary;
    }

    public ArrayList<String> getTeacherInfo(){
        ArrayList<String> data = new ArrayList<>();
        data.add("Name: " + this.name);
        data.add("Salary: " + this.salary + " USD");
        return data;
    }
}

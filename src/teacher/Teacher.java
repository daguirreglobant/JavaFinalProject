package teacher;

import java.util.ArrayList;

public class Teacher {
    protected String name;
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

    public ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        data.add("Name: " + this.name);
        data.add("Salary: " + String.valueOf(this.salary) + " USD");
        return data;
    }
}

package teacher;

import java.util.ArrayList;

public class FullTimeTeacher extends Teacher{
    private int experienceYears;

    public FullTimeTeacher(String name, int experienceYears){
        super(name);
        this.experienceYears = experienceYears;
        this.salary = baseSalary * ((float) (1.1 * experienceYears));
    }

    @Override
    public ArrayList<String> getData() {
        ArrayList<String> data = super.getData();
        data.add(0, "Type: Full time teacher");
        data.add("Experience years: " + String.valueOf(this.experienceYears));
        return data;
    }
}

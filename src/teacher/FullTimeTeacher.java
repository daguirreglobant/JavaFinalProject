package teacher;

import java.util.ArrayList;

public class FullTimeTeacher extends Teacher{
    private final int experienceYears;

    public FullTimeTeacher(String name, int experienceYears){
        super(name);
        this.experienceYears = experienceYears;
        this.salary = baseSalary * ((float) (1.1 * experienceYears));
    }

    @Override
    public ArrayList<String> getTeacherInfo() {
        ArrayList<String> data = super.getTeacherInfo();
        data.add(1, "Type: Full time teacher");
        data.add("Experience years: " + this.experienceYears);
        return data;
    }
}

package teacher;

import java.util.ArrayList;

public class PartTimeTeacher extends Teacher{
    private final float activeHoursPerWeek;

    public PartTimeTeacher(String name, float activeHoursPerWeek){
        super(name);
        this.activeHoursPerWeek = activeHoursPerWeek;
        this.salary = baseSalary * activeHoursPerWeek;
    }
    @Override
    public ArrayList<String> getTeacherInfo() {
        ArrayList<String> data = super.getTeacherInfo();
        data.add(1, "Type: Part time teacher");
        data.add("Active hours per week: " + this.activeHoursPerWeek + " hours");
        return data;
    }
}

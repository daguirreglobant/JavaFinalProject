package testing;

import university.Course;
import university.Student;
import university.University;
import university.teacher.FullTimeTeacher;
import university.teacher.PartTimeTeacher;
import university.teacher.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sample {

    public static University createSample(){
        List <Teacher> teacherSample = createTeacherSample();
        Map <Integer, Student> studentSample = createStudentSample();
        University university = new University(studentSample, teacherSample);
        Course [] courseSample = createCourseSample();
        int [][] sliceStudents = {{1, 2, 3},{2, 4}, {1, 2, 3, 4}, {1, 3}};
        for (int i = 0; i < courseSample.length; i++){
            university.addCourse(courseSample[i], teacherSample.get(i), sliceStudents[i]);
        }
        return university;
    }

    public static List <Teacher> createTeacherSample(){
        List <Teacher> teachers = new ArrayList<>();
        teachers.add(new FullTimeTeacher("David", 10));
        teachers.add(new FullTimeTeacher("Hernan", 5));
        teachers.add(new PartTimeTeacher("Pedro", 15));
        teachers.add(new PartTimeTeacher("Ernesto", 25));
        return teachers;
    }

    public static Map <Integer, Student> createStudentSample(){
        Map <Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, new Student(1, "Pepito", 19));
        studentMap.put(2, new Student(2, "JP", 23));
        studentMap.put(3, new Student(3, "Andres", 17));
        studentMap.put(4, new Student(4, "Daniel", 22));
        return studentMap;
    }

    public static Course [] createCourseSample(){
        Course mathCourse = new Course("Math", "A-112");
        Course englishCourse = new Course("English", "B-165");
        Course algebraCourse = new Course("Algebra", "A-100");
        Course spanishCourse = new Course("Spanish", "B-212");
        Course [] courses = {mathCourse, englishCourse, algebraCourse, spanishCourse};
        return courses;
    }
}

package testing;

import university.Course;
import university.Student;
import university.University;
import university.teacher.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        // Teacher.setBaseSalary(2000); // if you want to change the default salary base.
        University university = Sample.createSample();
        System.out.println("*********** Welcome to " + University.getName() + " ***********");
        while (!exit) {
            printMenu();
            System.out.print("Select an option: ");
            int optionSelected = Integer.parseInt(scanner.nextLine());
            switch (optionSelected) {
                case 1:
                    List<Teacher> teachers = university.getTeachers();
                    printTeachersInfo(teachers);
                    break;

                case 2:
                    List<Course> courses = university.getCourses();
                    printSubmenu(courses);
                    System.out.print("Select the course you want to analyze: ");
                    int courseOptionSelected = Integer.parseInt(scanner.nextLine()) - 1;
                    while (courseOptionSelected < 0 || courseOptionSelected >= courses.size()){
                        System.out.print("The course you selected doesn't exist, choose again: ");
                        courseOptionSelected = Integer.parseInt(scanner.nextLine()) - 1;
                    }
                    Course courseSelected = courses.get(courseOptionSelected);
                    printCourse(courseSelected);
                    break;

                case 3:
                    createNewStudent(university);
                    break;

                case 4:
                    createNewCourse(university);
                    break;

                case 5:
                    System.out.print("Student id: ");
                    int studentID = Integer.parseInt(scanner.nextLine());
                    int totalStudents = university.getTotalStudents();
                    while (studentID < 0 || studentID > totalStudents){
                        System.out.print("The student ID doesn't exist, choose again: ");
                        studentID = Integer.parseInt(scanner.nextLine());
                    }
                    Student student = university.getStudent(studentID);
                    System.out.println("---------------------------------");
                    System.out.println("STUDENT'S NAME: " + student.getName());
                    List<Course> studentCourses = student.getCourses();
                    printCourses(studentCourses);
                    break;

                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Selected option incorrect, back to menu.");
            }

        }
    }

    public static void printMenu() {
        System.out.println("*****************************************************");
        System.out.println("1. Print all the professors in University");
        System.out.println("2. Print all the courses and a specific course");
        System.out.println("3. Create a new student");
        System.out.println("4. Create a new course");
        System.out.println("5. Get all the courses of a specific student");
        System.out.println("6. Exit");
        System.out.println("*****************************************************");

    }
    public static void createNewCourse(University university){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Course name: ");
        String courseName = scanner.nextLine();
        while (university.containsCourse(courseName)){
            System.out.print("The course already exists, choose other course name: ");
            courseName = scanner.nextLine();
        }
        System.out.println("----------------------------------------");
        System.out.println("AVAILABLE TEACHERS");
        List<Teacher> teachers = university.getTeachers();
        printTeachersInfo(teachers);
        System.out.print("Teacher option: ");
        int teacherID = Integer.parseInt(scanner.nextLine()) - 1;
        while (teacherID < 0 || teacherID >= teachers.size()){
            System.out.print("The teacher you selected doesn't exist, choose again: ");
            teacherID = Integer.parseInt(scanner.nextLine()) - 1;
        }
        Teacher teacher = teachers.get(teacherID);
        System.out.print("Classroom: ");
        String classroom = scanner.nextLine();
        System.out.print("Add students by ID with space separator (e.g. 1 2 4): ");
        String studentsInput = scanner.nextLine();
        String[] studentsIDsString = studentsInput.split(" ", 0);
        // int[] studentsIDs = new int[studentsIDsString.length];
        List<Integer> studentsIDs = new ArrayList<>();
        int totalStudents = university.getTotalStudents();
        boolean anyStudentDoesntExist = false;
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < studentsIDsString.length; i++) {
            int studentID = Integer.parseInt(studentsIDsString[i]);
            if (studentID < 0 || studentID > totalStudents){
                System.out.println("The student ID " + studentID + " doesn't exist");
                anyStudentDoesntExist = true;
            }
            else {
                studentsIDs.add(studentID);
            }
        }
        if (anyStudentDoesntExist){
            System.out.println("The rest of students(if any) were added to the course.");
        }
        else{
            System.out.println("All the students were added to the course.");
        }
        System.out.println("------------------------------------------------------");
        int[] students = studentsIDs.stream().mapToInt(i -> i).toArray();
        Course course = new Course(courseName, classroom);
        university.addCourse(course, teacher, students);
    }
    public static void createNewStudent(University university){
        Scanner scanner = new Scanner(System.in);
        int totalStudents = university.getTotalStudents();
        System.out.print("Student's name: ");
        String name = scanner.nextLine();
        System.out.print("Students age: ");
        int age = Integer.parseInt(scanner.nextLine());
        Student student = new Student(totalStudents + 1, name, age);
        System.out.println("------------------");
        System.out.println("AVAILABLE COURSES:");
        List<Course> courses = university.getCourses();
        printCourses(courses);
        System.out.println("------------------");
        System.out.print("Course name: ");
        String courseName = scanner.nextLine();
        while (!university.containsCourse(courseName)){
            System.out.print("The course doesn't exist, choose other course name: ");
            courseName = scanner.nextLine();
        }
        university.enrollStudent(student, courseName);
        System.out.println("---------------");
        System.out.println("|STUDENT ID: " + student.getId() + "|");
        System.out.println("---------------");
    }
    public static void printSubmenu(List<Course> courses) {
        System.out.println("The currently university courses are: ");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + " " + courses.get(i).getName());
        }
    }

    public static void printTeachersInfo(List<Teacher> teachers) {
        for (int i = 0; i < teachers.size(); i++) {
            ArrayList<String> teacherInfo = teachers.get(i).getTeacherInfo();
            System.out.println("----------------------------------------");
            for (String characteristic : teacherInfo) {
                if (characteristic.contains("Name")) {
                    System.out.println((i + 1) + " " + characteristic);
                } else {
                    System.out.println("   " + characteristic);
                }
            }
            System.out.println("----------------------------------------");
        }
    }

    public static void printCourse(Course course) {
        System.out.println("---------------------------------");
        System.out.println("Course name: " + course.getName());
        System.out.println("Classroom: " + course.getClassroom());
        System.out.println("Teacher: " + course.getTeacher().getName());
        String students = "";
        for (Student student : course.getStudents()) {
            students += student.getName() + ", ";
        }
        System.out.println("Students: " + students.substring(0, students.length() - 2));
        System.out.println("---------------------------------");

    }

    public static void printCourses(List<Course> courses) {
        for (Course course : courses) {
            printCourse(course);
        }
    }

}

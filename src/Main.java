import teacher.FullTimeTeacher;
import teacher.PartTimeTeacher;
import teacher.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Teacher.setBaseSalary(2000); // if you want to change the default salary base.
        University university = new University();
        createSample(university);
        System.out.println("*********** Welcome to " + university.getName() +  " ***********");
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while (!exit){
            printMenu();
            System.out.print("Select an option: ");
            int optionSelected = Integer.parseInt(scanner.nextLine());
            switch (optionSelected){
                case 1:
                    ArrayList<Teacher> teachers = university.getTeachers();
                    printTeachersInfo(teachers);
                    break;

                case 2:
                    ArrayList<Course> courses =university.getCourses();
                    printSubmenu(courses);
                    System.out.print("Select the course you want to analyze: ");
                    int courseOptionSelected = Integer.parseInt(scanner.nextLine()) - 1;
                    Course courseSelected = courses.get(courseOptionSelected);
                    printCourse(courseSelected);
                    break;

                case 3:
                    int totalStudents = university.getTotalStudents();
                    System.out.print("Student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Students age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    Student student = new Student(totalStudents + 1, name, age);
                    System.out.print("Course name: ");
                    String courseName = scanner.nextLine();
                    university.enrollStudent(student, courseName);
                    break;

                case 4:
                    System.out.print("Course name: ");
                    courseName = scanner.nextLine();
                    teachers = university.getTeachers();
                    printTeachersInfo(teachers);
                    System.out.print("Teacher option: ");
                    int teacherID = Integer.parseInt(scanner.nextLine()) - 1;
                    Teacher teacher = teachers.get(teacherID);
                    System.out.print("Classroom: ");
                    String classroom = scanner.nextLine();
                    System.out.print("Add students by ID separated with spaces (e.g. 1 5 2): ");
                    String studentsInput = scanner.nextLine();
                    String[] studentsIDsString = studentsInput.split(" ",0);
                    int[] studentsIDs = new int[studentsIDsString.length];
                    for (int i = 0; i < studentsIDs.length; i++){
                        studentsIDs[i] = Integer.parseInt(studentsIDsString[i]);
                    }
                    Course course = new Course(courseName, classroom);
                    university.addCourse(course, teacher, studentsIDs);
                    break;

                case 5:
                    System.out.print("Student id: ");
                    int studentID = Integer.parseInt(scanner.nextLine());
                    courses = university.getCoursesByStudentID(studentID);
                    printCourses(courses);
                    break;

                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Selected option incorrect, back to menu.");
            }

        }
    }

    public static void printMenu(){
        System.out.println("-----------------------------------------------------");
        System.out.println("1. Print all the professors in University");
        System.out.println("2. Print all the courses and a specific course");
        System.out.println("3. Create a new student");
        System.out.println("4. Create a new course");
        System.out.println("5. Get all the courses of a specific student");
        System.out.println("6. Exit");
        System.out.println("-----------------------------------------------------");

    }

    public static void printSubmenu(ArrayList<Course> courses){
        System.out.println("The currently university courses are: ");
        for (int i = 0; i < courses.size(); i++){
            System.out.println((i + 1) + " " + courses.get(i).getName());
        }
    }
    public static void printTeachersInfo(ArrayList<Teacher> teachers){
        for (int i = 0; i < teachers.size(); i++){
            ArrayList<String> teacherInfo = teachers.get(i).getTeacherInfo();
            for(String characteristic: teacherInfo) {
                if (characteristic.contains("Name")){
                    System.out.println((i+1) + " " + characteristic);
                }
                else{
                    System.out.println("   " + characteristic);
                }
            }
            System.out.println();
        }
    }

    public static void printCourse(Course course){
        System.out.println("Course name: " + course.getName());
        System.out.println("Classroom: " + course.getClassroom());
        System.out.println("Teacher: " + course.getTeacher().getName());
        String students = "";
        for (Student student: course.getStudents()){
            students += student.getName() + ", ";
        }
        System.out.println("Students: " + students.substring(0, students.length() - 2) + "\n");

    }

    public static void printCourses(ArrayList <Course> courses){
        for (Course course: courses){
            printCourse(course);
        }
    }

    public static void createSample(University university){
        createTeacherSample(university);
        createCourseSample(university);
        createStudentSample(university);
    }

    public static void createTeacherSample(University university){
        FullTimeTeacher teacher1 = new FullTimeTeacher("David", 10);
        PartTimeTeacher teacher2 = new PartTimeTeacher("Pedro", 25);
        university.addTeacher(teacher1);
        university.addTeacher(teacher2);
    }

    public static void createStudentSample(University university){
        Student student1 = new Student(1, "Pepito", 19);
        Student student2 = new Student(2, "JP", 23);
        Student student3 = new Student(3, "Andres", 17);
        Student student4 = new Student(4, "Daniel", 22);
        university.enrollStudent(student1, "Algebra");
        university.enrollStudent(student2, "Algebra");
        university.enrollStudent(student3, "Algebra");
        university.enrollStudent(student1, "Math");
        university.enrollStudent(student2, "English");
        university.enrollStudent(student4, "Spanish");
    }

    public static void createCourseSample(University university){
        ArrayList<Teacher> teachers = university.getTeachers();
        Course mathCourse = new Course("Math", "A-112", teachers.get(0));
        Course englishCourse = new Course("English", "B-165", teachers.get(0));
        Course algebraCourse = new Course("Algebra", "A-100", teachers.get(1));
        Course spanishCourse = new Course("Spanish", "B-212", teachers.get(1));
        university.addCourse(mathCourse);
        university.addCourse(englishCourse);
        university.addCourse(algebraCourse);
        university.addCourse(spanishCourse);

    }
}

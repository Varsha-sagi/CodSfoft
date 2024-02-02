package CodSoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRegistration {

    private List<String> courses;
    private List<String> enrolledCourses;

    public StudentRegistration() {
        courses = new ArrayList<>();
        enrolledCourses = new ArrayList<>();
        initializeCourses();
    }

    private void initializeCourses() {
        courses.add("Mathematics");
        courses.add("Physics");
        courses.add("Computer Science");
        courses.add("Chemistry");
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Student Registration System!");

        while (true) {
            displayMenu();
            int choice = getChoice(sc);

            switch (choice) {
                case 1:
                    AvailableCourses();
                    break;
                case 2:
                    enrollInCourse(sc);
                    break;
                case 3:
                    EnrolledCourses();
                    break;
                case 4:
                    System.out.println("Exiting Student Registration System...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("1. Display Available Courses");
        System.out.println("2. Enroll in a Course");
        System.out.println("3. Display Enrolled Courses");
        System.out.println("4. Exit");
    }


    private int getChoice(Scanner sc)
    {
        System.out.print("Enter your choice: ");
        while (!sc.hasNextInt())
        {
            System.out.println("Invalid input. Please enter a number.");
            sc.next();
        }
        return sc.nextInt();
    }


    private void AvailableCourses()
    {
        System.out.println("Available Courses:");
        for (int i = 0; i < courses.size(); i++)
        {
            System.out.println((i + 1) + ". " + courses.get(i));
        }
    }


    private void enrollInCourse(Scanner sc)
    {
        AvailableCourses();
        System.out.print("Enter the course you want to enroll in: ");
        while (!sc.hasNextInt())
        {
            System.out.println("Invalid input. Please enter a number.");
            sc.next();
        }
        int courseNumber = sc.nextInt();

        if (courseNumber >= 1 && courseNumber <= courses.size())
        {
            String selected = courses.get(courseNumber - 1);
            enrolledCourses.add(selected);
            System.out.println("Enrollment in " + selected + " successful.");
        }
        else
        {
            System.out.println("Invalid course number. Please try again.");
        }
    }


    private void EnrolledCourses()
    {
        if (enrolledCourses.isEmpty())
        {
            System.out.println("You are not enrolled in any courses.");
        }
        else {
            System.out.println("Enrolled Courses:");
            for (String course : enrolledCourses) {
                System.out.println("- " + course);
            }
        }
    }


    public static void main(String[] args)
    {
        StudentRegistration studentRegistration = new StudentRegistration();
        studentRegistration.start();
    }
}


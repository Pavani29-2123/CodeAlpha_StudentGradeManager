import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Manager ===");

        boolean continueInput = true;
        while (continueInput) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            double grade = -1;
            while (grade < 0 || grade > 100) {
                System.out.print("Enter grade (0-100): ");
                if (scanner.hasNextDouble()) {
                    grade = scanner.nextDouble();
                    if (grade < 0 || grade > 100) {
                        System.out.println("Grade must be between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); 
                }
            }

            students.add(new Student(name, grade));
            scanner.nextLine();

            System.out.print("Add another student? (y/n): ");
            String answer = scanner.nextLine().toLowerCase();
            continueInput = answer.equals("y");
        }

       
        if (students.isEmpty()) {
            System.out.println("No students entered.");
        } else {
            double total = 0;
            double highest = Double.MIN_VALUE;
            double lowest = Double.MAX_VALUE;
            String topStudent = "";
            String lowStudent = "";

            System.out.println("\n=== Summary Report ===");
            System.out.printf("%-20s %10s%n", "Student Name", "Grade");
            System.out.println("-------------------------------");

            for (Student s : students) {
                System.out.printf("%-20s %10.2f%n", s.name, s.grade);
                total += s.grade;

                if (s.grade > highest) {
                    highest = s.grade;
                    topStudent = s.name;
                }

                if (s.grade < lowest) {
                    lowest = s.grade;
                    lowStudent = s.name;
                }
            }

            double average = total / students.size();
            System.out.println("-------------------------------");
            System.out.printf("Average Grade: %.2f%n", average);
            System.out.printf("Highest Grade: %.2f (%s)%n", highest, topStudent);
            System.out.printf("Lowest Grade : %.2f (%s)%n", lowest, lowStudent);
        }

        scanner.close();
    }
}

package TermProject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReportGenerator {

    static final int NUM_STUDENTS = 10;
    static final int NUM_SUBJECTS = 5;
    static final String[] SUBJECTS = {"Math", "English", "Programming", "Economics", "Physics"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[NUM_STUDENTS];

        // Input
        for (int i = 0; i < NUM_STUDENTS; i++) {
            System.out.println("\nEnter details for student " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("ID: ");
            String id = scanner.nextLine();
            students[i] = new Student(name, id, NUM_SUBJECTS);

            for (int j = 0; j < NUM_SUBJECTS; j++) {
                int score;
                while (true) {
                    System.out.print("Score in " + SUBJECTS[j] + " : ");
                    score = scanner.nextInt();
                    if (score >= 0 && score <= 100) {
                        break; // valid score
                    } else {
                        System.out.println(" Invalid input. Please enter a number between 0 and 100.");
                    }
                }
                students[i].scores[j] = score;
            }
            scanner.nextLine(); // consume newline

            scanner.nextLine(); // Consume newline
        }

        // Output
        for (Student student : students) {
            printReportCard(student);
        }

        scanner.close();
    }
    public double calculateAverage(int[] scores) {
        if (scores.length == 0) return 0;
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return (double) total / scores.length;
    }
    public static void printReportCard(Student student) {
        double average = GradeCalculator.calculateAverage(student.scores);

        String grade = GradeCalculator.getGrade(average);
        String recommendation = GradeCalculator.getRecommendation(grade);
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        System.out.println("\n--- Report Card ---");
        System.out.println("Name: " + student.name);
        System.out.println("ID: " + student.id);
        System.out.println("Scores:");
        for (int i = 0; i < student.scores.length; i++) {
            System.out.println(SUBJECTS[i] + ": " + student.scores[i]);
        }
        System.out.printf("Average: %.2f\n", average);
        System.out.println("Grade: " + grade);
        System.out.println("Recommendation: " + recommendation);
        System.out.println("Date Viewed: " + date);
    }
}
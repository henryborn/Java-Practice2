import java.util.Scanner;
public class classGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents;
        int numberOfAssignments;
        double averageGrade = 0.0;
        double grade = 0.0;
        double highestGrade = 0.0;
        String studentName;
        String highestScorer = "";
        String highestAverage = "";
        double highestAverageGrade = 0.0;
        double classAverage = 0.0;

        while (true) {
            System.out.print("How many students are in the class?: ");
        if (scanner.hasNextDouble()) {
            double placeholder = scanner.nextDouble();
            if (isInteger(placeholder) && placeholder > 0) {
                numberOfStudents = (int) placeholder;
                System.out.println("There are " + numberOfStudents + " students in the class.");
                scanner.nextLine();
                break;
            } else {
                System.out.println("Sybau, put a positive integer");
            }
        }
        else {
            System.out.println("yo bro you can't have imaginary students and we use the decimal system not fucking letters and symbols, please enter a positive integer.");
            scanner.next();
        }
    }
    Student[] pupil = new Student[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentName = scanner.nextLine();
            pupil[i] = new Student(studentName, averageGrade, highestGrade);
        }
        while (true) {
            System.out.print("How many assignments have been graded?: ");
            if (scanner.hasNextDouble()) {
                double placeholder = scanner.nextDouble();
                if (isInteger(placeholder) && placeholder > 0) {
                    numberOfAssignments = (int) placeholder;
                    System.out.println("There are " + numberOfAssignments + " assignments graded.");
                    break;
                } else {
                    System.out.println("Sybau, put a positive integer");
                }
            } else {
                System.out.println("yo bro you can't have imaginary assignments and we use the decimal system not fucking letters and symbols, please enter a positive integer.");
                scanner.next();
            }
        }
        for (int i = 0; i < numberOfStudents; i++) {
            averageGrade = 0.0;
            for (int j = 0; j < numberOfAssignments; j++) {
                System.out.print("Enter the grade for student " + (i + 1) + ", " + pupil[i].getName() +" for assignment " + (j + 1) + ": ");
                if (scanner.hasNextDouble()) {
                    grade = scanner.nextDouble();
                    if (grade < 0 || grade > 100) {
                        System.out.println("you make papa angry, put a grade between 0 and 100");
                        j--; // Decrement j to repeat this assignment for the same student
                    } else {
                        averageGrade += grade;
                        if (grade > pupil[i].getHighestGrade()) {
                            pupil[i].setHighestGrade(grade);
                            highestGrade = grade;
                }
                    }
                } else {
                    System.out.println("PUT THE FUCKING RIGHT THING, YOU KNOW WHAT IT WANTS");
                    scanner.next(); // Clear invalid input
                    j--; // Decrement j to repeat this assignment for the same student
                }
            }
            averageGrade /= numberOfAssignments;
            pupil[i].setAverage(averageGrade);
            if (averageGrade > highestAverageGrade) {
                highestAverageGrade = averageGrade;
            }

            if (pupil[i].getHighestGrade() == highestGrade) {
                highestScorer = pupil[i].getName() + " and " + highestScorer;
            }

            else if (pupil[i].getHighestGrade() > highestGrade) {
                highestScorer = pupil[i].getName();
            }

            if (pupil[i].getAverage() == highestAverageGrade) {
                highestAverage = pupil[i].getName() + " and " + highestAverage;
            }
            else if (pupil[i].getAverage() > highestAverageGrade) {
                highestAverage = pupil[i].getName();
            }
            classAverage += pupil[i].getAverage();
    }
    classAverage /= numberOfStudents;
    for (int i = 0; i < numberOfStudents; i++) {
        if (highestScorer.equals(pupil[i].getName())) {
            highestGrade = pupil[i].getHighestGrade();
        }
        if (highestAverage.equals(pupil[i].getName())) {
            highestAverageGrade = pupil[i].getAverage();
        }
    }
    for (int i = 0; i < numberOfStudents; i++) {
        System.out.println("Student: " + pupil[i].getName() + ", had an average grade of: " + pupil[i].getAverage() + "%, with a highest grade of: " + pupil[i].getHighestGrade() + "%");
    }

    System.out.println("Highest scorer in the class is: " + highestScorer + " with a grade of " + highestGrade + "%");
    System.out.println("Highest average scorer in the class is: " + highestAverage + " with an average of " + highestAverageGrade + "%");
    System.out.println("Class average is: " + classAverage + "%");
    scanner.close();
}
    public static boolean isInteger(double integer) {
        return integer == (int) integer;
    }
}
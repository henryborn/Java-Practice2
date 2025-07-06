import java.util.Scanner;
public class classGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
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
                    break;
                } else {
                    System.out.println("Sybau, put a positive integer");
                }
            } else {
                System.out.println("yo bro you can't have imaginary assignments and we use the decimal system not fucking letters and symbols, please enter a positive integer.");
                scanner.next();
            }
        }
        String[] assignmentNames = new String[numberOfAssignments];
        System.out.print("Would you like names of the assignment to be displayed with the grades? (yes/no): ");
        String withNames = scanner2.nextLine();
        for (int j = 0; j < numberOfAssignments; j++) {
            while (true) {
                if (withNames.equalsIgnoreCase("yes")) {
                    System.out.print("Enter the name of assignment " + (j + 1) + ": ");
                    String assignmentName = scanner2.nextLine();
                    assignmentNames[j] = assignmentName;
                    break;
                }
                else if (withNames.equalsIgnoreCase("no")) {
                    assignmentNames[j] = "Assignment " + (j + 1);
                    break;
                } else {
                    System.out.println("Please enter 'yes' or 'no'.");
                    j--;
                    continue;
                }
            }
        }
        for (int i = 0; i < numberOfStudents; i++) {
            averageGrade = 0.0;
            for (int j = 0; j < numberOfAssignments; j++) {
                System.out.print("Enter the grade for student " + (i + 1) + ", " + pupil[i].getName() + " for " + assignmentNames[j] + ": ");
                if (scanner.hasNextDouble()) {
                    grade = scanner.nextDouble();
                    if (grade < 0 || grade > 100) {
                        System.out.println("you make papa angry, put a grade between 0 and 100");
                        j--;
                    } else {
                        averageGrade += grade;
                        pupil[i].addGrade(grade);
                        if (withNames.equalsIgnoreCase("yes")) {
                            pupil[i].addLetterGrade(assignmentNames[j] + " has a grade of " + grade + "%, which is an " + letterGrade(grade) + ".");
                        } else {
                            pupil[i].addLetterGrade(letterGrade(grade));
                        }
                        if (grade > pupil[i].getHighestGrade()) {
                            pupil[i].setHighestGrade(grade);
                }
                    }
                } else {
                    System.out.println("PUT THE FUCKING RIGHT THING, YOU KNOW WHAT IT WANTS");
                    scanner.next();
                    j--;
                }
            }
            averageGrade /= numberOfAssignments;
            pupil[i].setAverage(averageGrade);
            if (pupil[i].getHighestGrade() > highestGrade) {
                highestGrade = pupil[i].getHighestGrade();
                highestScorer = pupil[i].getName();
            } else if (pupil[i].getHighestGrade() == highestGrade) {
                highestScorer += ", " + pupil[i].getName();
            }
            if (averageGrade > highestAverageGrade) {
                highestAverageGrade = averageGrade;
                highestAverage = pupil[i].getName();
            } else if (averageGrade == highestAverageGrade) {
                highestAverage += ", " + pupil[i].getName();
            }
            classAverage += pupil[i].getAverage();
    }
    classAverage /= numberOfStudents;
    System.out.println("Highest scorer in the class is: " + highestScorer + " with a grade of " + highestGrade + "%, or an " + letterGrade(highestGrade) + ".");
    System.out.println("Highest average scorer in the class is: " + highestAverage + " with an average of " + highestAverageGrade + "%, or an " + letterGrade(highestAverageGrade) + ".");
    System.out.println("Class average is: " + classAverage + "%");
    while (true) {
        System.out.print("Would you like to see each students average and highest grade? (yes/no): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("yes")) {
            for (int i = 0; i < numberOfStudents; i++) {
                System.out.println("Student: " + pupil[i].getName() + ", had an average grade of: " + pupil[i].getAverage() + "%, which is an " + letterGrade(pupil[i].getAverage()) + " with a highest grade of: " + pupil[i].getHighestGrade() + "%, which is an " + letterGrade(pupil[i].getHighestGrade()) + ".");
            }
            break;
        } else if (response.equalsIgnoreCase("no")) {
            break;
        } else {
            System.out.println("Please enter 'yes' or 'no'.");
        }
    }
    while (true) {
        System.out.println("Would you like to see each students letter grades? (yes/no): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("yes")) {
            for (int i = 0; i < numberOfStudents; i++) {
                System.out.println("Student: " + pupil[i].getName() + ", had the following letter grades: " + pupil[i].getLetterGrades());
            }
            break;
        } else if (response.equalsIgnoreCase("no")) {
            System.out.println("Would you like to see all of the grades and letter grades for a specific student? (yes/no): ");
            String response2 = scanner.next();
        if (response2.equalsIgnoreCase("yes")) {
                System.out.print("Enter the name of the student you want to see grades for: ");
                scanner.nextLine();
                String studentNameToCheck = scanner.nextLine();
                boolean found = false;
                for (int i = 0; i < numberOfStudents; i++) {
                    if (pupil[i].getName().equalsIgnoreCase(studentNameToCheck)) {
                        if (withNames.equalsIgnoreCase("yes")) {
                            System.out.println("Student: " + pupil[i].getName() + ", on assignment " + pupil[i].getLetterGrades() + "\nAverage: " + pupil[i].getAverage() + "%, or an " + letterGrade(pupil[i].getAverage()) + " with their highest grade being a: " + pupil[i].getHighestGrade() + "%, or an " + letterGrade(pupil[i].getHighestGrade()) + ".");
                        } else
                        System.out.println("Student: " + pupil[i].getName() + ", had the following letter grades: " + pupil[i].getLetterGrades() + " and grades: " + pupil[i].getGrades() + "\nAverage: " + pupil[i].getAverage() + "%, or an " + letterGrade(pupil[i].getAverage()) + " with their highest grade being a: " + pupil[i].getHighestGrade() + "%, or an " + letterGrade(pupil[i].getHighestGrade()) + ".");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student not found.");
                }
            }
            break;
        } else {
            System.out.println("Please enter 'yes' or 'no'.");
        }
    }
    scanner.close();
    scanner2.close();
}
    public static boolean isInteger(double integer) {
        return integer == (int) integer;
    }
    public static String letterGrade(double grade) {
        if (grade >= 98 && grade <= 100) {
            return "A+";
        } else if (grade >= 93 && grade < 98) {
            return "A";
        } else if (grade >= 90 && grade < 93) {
            return "A-";
        } else if (grade >= 87 && grade < 90) {
            return "B+";
        } else if (grade >= 83 && grade < 87) {
            return "B";
        } else if (grade >= 80 && grade < 83) {
            return "B-";
        } else if (grade >= 77 && grade < 80) {
            return "C+";
        } else if (grade >= 73 && grade < 77) {
            return "C";
        } else if (grade >= 70 && grade < 73) {
            return "C-";
        } else if (grade >= 67 && grade < 70) {
            return "D+";
        } else if (grade >= 63 && grade < 67) {
            return "D";
        } else if (grade >= 60 && grade < 63) {
            return "D-";
        } else {
            return "F";
        }
    }
}
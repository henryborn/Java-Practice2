import java.util.ArrayList;

public class Student {
    private String name;
    private double average;
    private double highestGrade;
    private ArrayList<String> letterGrades = new ArrayList<>();
    private ArrayList<Double> grades = new ArrayList<>();

    public Student(String name, double average, double highestGrade) {
        this.name = name;
        this.average = average;
        this.highestGrade = highestGrade;
        this.letterGrades = new ArrayList<>();
        this.grades = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public double getAverage() {
        return average;
    }
    public void setAverage(double average) {
        this.average = average;
    }
    public double getHighestGrade() {
        return highestGrade;
    }
    public void setHighestGrade(double highestGrade) {
        this.highestGrade = highestGrade;
    }
    public ArrayList<String> getLetterGrades() {
        return letterGrades;
    }
    public void addLetterGrade(String letterGrade) {
        letterGrades.add(letterGrade);
    }
    public ArrayList<Double> getGrades() {
        return grades;
    }
    public void addGrade(double grade) {
        grades.add(grade);
    }

    
}
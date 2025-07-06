public class Student {
    private String name;
    private double average;
    private double highestGrade;

    public Student(String name, double average, double highestGrade) {
        this.name = name;
        this.average = average;
        this.highestGrade = highestGrade;
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
}
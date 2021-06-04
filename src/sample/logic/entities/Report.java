package sample.logic.entities;

public class Report {

    private String department, description;
    private int count;

    public Report(String department, int count, String description) {
        this.department = department;
        this.count = count;
        this.description = description;
    }

    public void incrementCount() {
        count++;
    }
}

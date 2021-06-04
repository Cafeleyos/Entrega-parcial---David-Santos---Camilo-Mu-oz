package sample.logic.entities;

public class Report {

    private String information, description;
    private double count;

    public Report(String information, double count, String description) {
        this.information = information;
        this.count = count;
        this.description = description;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void incrementCount() {
        count++;
    }
}

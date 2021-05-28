package sample.logic.entities;

public class PublicEmployee extends Person {
    private String job;

    public PublicEmployee(String name, String lastName, int age, String sex, String department, String condition, String reason, String id) {
        super(name, lastName, age, sex, department, condition, reason, id);
    }
}

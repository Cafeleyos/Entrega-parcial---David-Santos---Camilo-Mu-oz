package sample.logic.entities;

import sample.logic.services.PersonaException;

public class PublicEmployee extends Person {
    private String job;

    public PublicEmployee(String name, String lastName, String age, String sex, String department, String condition, String reason, String id) throws PersonaException {
        super(name, lastName, age, sex, department, condition, reason, id);
    }
}

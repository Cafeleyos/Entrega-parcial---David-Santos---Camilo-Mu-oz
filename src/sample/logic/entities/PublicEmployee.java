package sample.logic.entities;

import sample.logic.services.PersonaException;



public class PublicEmployee extends Persona{
    private String job;

    public PublicEmployee(String name, String lastName, String age, String sex, String department, String condition, String reason, String id, String position) throws PersonaException {
        super(name, lastName, age, sex, department, condition, reason, id);
        this.job = position;
    }

    public String getPosition() {
        return this.job;
    }


    @Override
    public String toString() {
        return super.toString() +
                "Trabajo: " + job;
    }
}

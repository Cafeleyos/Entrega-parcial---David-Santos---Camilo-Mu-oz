package sample.logic.entities;

import javafx.scene.Node;
import sample.logic.services.PersonaException;

import java.io.Serializable;

public class Persona implements Serializable {
    private String name;
    private String lastName;
    private int age;
    private String sex;
    private String department;
    private String condition;
    private String reason;
    private String id;
    public static final int MAX_ID_DIGITS = 10;
    public static final int MIN_ID_DIGITS = 8;
    public static final int MAX_AGE = 150;
    public static final int MIN_AGE = 1;

    public Persona(String name, String lastName, String age, String sex, String department, String condition, String reason, String id) throws PersonaException {
        this.name = name;
        this.lastName = lastName;
        setAge(age);
        this.sex = sex;
        this.department = department;
        this.condition = condition;
        this.reason = reason;
        setId(id);
    }

    public String getName() {
        return this.name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getCondition() {
        return this.condition;
    }

    public String getId() {
        return this.id;
    }

    private void setAge(String inputAge) throws PersonaException {
        try {
            int result = Integer.parseInt(inputAge);
            if (result> MAX_AGE) throw new PersonaException(PersonaException.UPPER_AGE);
            if (result< MIN_AGE) throw new PersonaException(PersonaException.UNDER_AGE);
            this.age = result;
        } catch (NumberFormatException e) {
            throw new PersonaException(PersonaException.INVALID_CHARACTERS);
        }

    }

    private void setId(String inputId) throws PersonaException {
        try {
            Long.parseLong(inputId);
            if(inputId.length()< MIN_ID_DIGITS) throw new PersonaException(PersonaException.UNDER_ID);
            if(inputId.length()> MAX_ID_DIGITS) throw new PersonaException(PersonaException.UPPER_ID);
            this.id = inputId;
        } catch (NumberFormatException e) {
            throw new PersonaException(PersonaException.INVALID_CHARACTERS);
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", department='" + department + '\'' +
                ", condition='" + condition + '\'' +
                ", reason='" + reason + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

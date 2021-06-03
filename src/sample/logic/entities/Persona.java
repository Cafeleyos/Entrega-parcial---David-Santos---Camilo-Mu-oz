package sample.logic.entities;

import javafx.scene.Node;
import sample.logic.services.PersonaException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persona extends Exportable implements Serializable {
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

    public String getPosition() { return "Civil";}

    public String getSex() { return this.sex;}

    public int getAge() { return age; }

    public String getDepartment() { return department; }

    public String getReason() { return reason; }

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
        return String.format("Nombre Completo: " + name + " " + lastName + "\n"
                + "Edad: " + age + "\n"
                + "Sexo: " + sex + "\n"
                + "Cédula: " + id + "\n"
                + "Departamento: " + department + "\n"
                + "Condición: " + condition + "\n"
                + "Razón: " + reason + "\n");
    }

    @Override
    public List<String> toListString() {
        List<String> result = new ArrayList<>();

        result.add(this.name);
        result.add(this.lastName);
        result.add(String.valueOf(this.age));
        result.add(this.sex);
        result.add(this.department);
        result.add(this.condition);
        result.add(this.reason);
        result.add(this.id);

        return result;
    }

    @Override
    public String getHeader(Character separateCharacter) {
        return "Nombre" + separateCharacter + "Apellido" + separateCharacter + "Edad" + separateCharacter + "Sexo" +
                separateCharacter + "Departamento" + separateCharacter + "Condición" + separateCharacter + "Razón" +
                separateCharacter + "Cédula";
    }
}

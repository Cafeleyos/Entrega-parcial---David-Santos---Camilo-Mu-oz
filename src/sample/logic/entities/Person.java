package sample.logic.entities;

import sample.logic.services.PersonException;
import sample.logic.services.implementation.PersonaServices;

public class Person {
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

    public Person(String name, String lastName, String age, String sex, String department, String condition, String reason, String id) throws PersonException {
        this.name = name;
        this.lastName = lastName;
        setAge(age);
        this.sex = sex;
        this.department = department;
        this.condition = condition;
        this.reason = reason;
        setId(id);
    }

    private void setAge(String inputAge) throws PersonException {
            try {
            int result = Integer.parseInt(inputAge);
            if (result> 150) throw new PersonException(PersonException.UPPER_AGE);
            if (result<= 0) throw new PersonException(PersonException.UNDER_AGE);
            this.age = result;
        } catch (NumberFormatException e) {
            throw new PersonException(PersonException.INVALID_CHARACTERS);
        }

    }
    private void setId(String inputId) throws PersonException {
        try {
            Long.parseLong(inputId);
            if(inputId.length()< MIN_ID_DIGITS) throw new PersonException(PersonException.UNDER_ID);
            if(inputId.length()> MAX_ID_DIGITS) throw new PersonException(PersonException.UPPER_ID);
        } catch (NumberFormatException e) {
            throw new PersonException(PersonException.INVALID_CHARACTERS);
        }
    }




}

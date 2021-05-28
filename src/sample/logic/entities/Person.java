package sample.logic.entities;

import sample.logic.services.PersonException;

public class Person {
    private String name;
    private String lastName;
    private int age;
    private String sex;
    private String department;
    private String condition;
    private String reason;
    private String id;
    public static final int MAX_ID_DIGITS = 8;
    public static final int MIN_ID_DIGITS = 11;

    public Person(String name, String lastName, int age, String sex, String department, String condition, String reason, String id) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.department = department;
        this.condition = condition;
        this.reason = reason;
        this.id = id;
    }

    private void setAge(String inputAge) throws PersonException {
        if(inputAge==null) {
            throw new PersonException(PersonException.MISSING_AGE_PARAMETER_);
        }
        try {
            int result = Integer.parseInt(inputAge);
            if (result> 150) throw new PersonException(PersonException.UPPER_AGE);
            if (result<= 0) throw new PersonException(PersonException.UNDER_AGE);
        } catch (NumberFormatException e) {
            throw new PersonException(PersonException.INVALID_CHARACTERS);
        }
    }
    private void setId(String inputId) throws PersonException {
        if(inputId==null) {
            throw new PersonException(PersonException.MISSING_AGE_PARAMETER_);
        }
        try {
            int result = Integer.parseInt(inputId);
            if (result> 150) throw new PersonException(PersonException.UPPER_AGE);
            if (result<= 0) throw new PersonException(PersonException.UNDER_AGE);
        } catch (NumberFormatException e) {
            throw new PersonException(PersonException.INVALID_CHARACTERS);
        }
    }


}

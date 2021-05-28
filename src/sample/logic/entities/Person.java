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
    public static final int MIN_ID_DIGITS = 10;

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
        if(inputAge==null) {
            throw new PersonException(PersonException.MISSING_PARAMETER);
        }
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
        int count =0;
        if(inputId==null) {
            throw new PersonException(PersonException.MISSING_PARAMETER);
        }
        try {
            Long.parseLong(inputId);
            for (int i = 0; i < inputId.length(); i++) {
                if(inputId.charAt(i)== 'a'){

                }
            }


        } catch (NumberFormatException e) {
            throw new PersonException(PersonException.INVALID_CHARACTERS);
        }
    }


}

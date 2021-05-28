package sample.logic.services;

public class PersonException extends Exception{
    public static final String UNDER_AGE = "La edad introducida es menor a 0 años";
    public static final String UPPER_AGE = "La edad introducida es mayor a 150 años";
    public static final String UPPER_ID = "El Id supera los 10 digitos";
    public static final String UNDER_ID = "El Id tiene menos de 8 digitos";
    public static final String INVALID_CHARACTERS = "El parametro introducido es invalido";




    public PersonException(String message) {
        super(message);
    }
}

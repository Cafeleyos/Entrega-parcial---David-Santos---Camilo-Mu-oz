package sample.logic.services;

public class PersonException extends Exception{
    public static final String UNDER_AGE = "La edad introducida es menor a 0 años";
    public static final String UPPER_AGE = "La edad introducida es mayor a 150 años";
    public static final String INVALID_CHARACTERS = "El parametro introducido es invalido";
    public static final String MISSING_PARAMETER = "Parametro vacío";



    public PersonException(String message) {
        super(message);
    }
}

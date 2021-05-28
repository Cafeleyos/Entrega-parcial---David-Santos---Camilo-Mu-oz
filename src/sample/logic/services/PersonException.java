package sample.logic.services;

public class PersonException extends Exception{
    public static final String UNDER_AGE = "La edad introducida es menor a 0 años";
    public static final String UPPER_AGE = "La edad introducida es mayor a 150 años";
    public static final String INVALID_CHARACTERS = "La edad indtroducida no es valida, ingrese un numero entre 1 y 150";
    public static final String MISSING_AGE_PARAMETER_ = "El parametro de edad esta vacío";



    public PersonException(String message) {
        super(message);
    }
}

package sample.logic.services;

public class PersonaException extends Exception{
    public static final String UNDER_AGE = "La edad introducida es menor a 0 años";
    public static final String UPPER_AGE = "La edad introducida es mayor a 150 años";
    public static final String UPPER_ID = "El Id supera los 10 digitos";
    public static final String UNDER_ID = "El Id tiene menos de 8 digitos";
    public static final String INVALID_CHARACTERS = "El parametro introducido es invalido";
    public static final String EQUAL_ID = "EL id ya existe en el sistema";
    public static final String NULL_ID = "El id no existe en el sistema";
    public static final String INVALID_PERSON = "La persona no existe en el sistema";
    public static final String POST_DATE = "La fecha agregada es futura. Agregue una fecha valida";
    public static final String MAX_AGE = "La fecha de nacimiento supera los 150 años";
    public static final String ZERO_AGE = "La edad será 0. Agregue una fecha valida";




    public PersonaException(String message) {
        super(message);
    }
}

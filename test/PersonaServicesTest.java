import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.logic.entities.Persona;
import sample.logic.services.PersonaException;
import sample.logic.services.implementation.PersonaServices;

import java.io.IOException;

public class PersonaServicesTest {

    private String name = "Santiago";
    private String lastName = "Santos";

    private PersonaServices personaServices = new PersonaServices();

    @Test
    public void ShouldDeleteAPerson() throws PersonaException, IOException {
        Persona p = new Persona(name, lastName, ConstantsForTests.VALID_AGE, ConstantsForTests.VALID_SEX,
                ConstantsForTests.VALID_DEPARTMENT, ConstantsForTests.VALID_STATE, "Abuso Policial",
                ConstantsForTests.VALID_ID);

        Assertions.assertNotNull(p);
        Assertions.assertNotNull(personaServices);

        personaServices.insert(p);
        Assertions.assertNotNull(personaServices.getAll());

        Assertions.assertTrue(personaServices.delete(p));
    }

    @Test
    public void ShouldThrowNullIdException() {
        PersonaException result = Assertions.assertThrows(PersonaException.class, () -> personaServices.findIndex("10"));
        Assertions.assertEquals(result.getMessage(), PersonaException.NULL_ID);
    }

    @Test
    public void ShouldThrowInvalidPersonException() {
        PersonaException result = Assertions.assertThrows(PersonaException.class, () -> personaServices.delete(new Persona(
                name, lastName, ConstantsForTests.VALID_AGE, ConstantsForTests.VALID_SEX,
                ConstantsForTests.VALID_DEPARTMENT, ConstantsForTests.VALID_STATE, "Abuso Policial",
                ConstantsForTests.VALID_ID)));
        Assertions.assertEquals(result.getMessage(), PersonaException.INVALID_PERSON);
    }
}
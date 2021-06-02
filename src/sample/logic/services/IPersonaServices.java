package sample.logic.services;

import sample.logic.entities.Persona;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IPersonaServices {
    List<Persona> getAll();
    Persona insert(Persona persona) throws IOException, PersonaException;
    void modify(Persona persona);
    void delete(Persona persona);
    void export() throws FileNotFoundException;
}

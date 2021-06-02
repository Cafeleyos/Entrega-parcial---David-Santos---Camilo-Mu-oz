package sample.logic.services;

import sample.logic.entities.Persona;

import java.io.IOException;
import java.util.List;

public interface IPersonaServices {
    List<Persona> getAll();
    Persona insert(Persona persona) throws IOException;
    void modify(Persona persona);
    void delete(Persona persona);
}

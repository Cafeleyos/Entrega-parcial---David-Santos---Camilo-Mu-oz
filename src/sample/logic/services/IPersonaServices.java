package sample.logic.services;

import sample.logic.entities.Persona;

import java.util.List;

public interface IPersonaServices {
    List<Persona> getAll();
    Persona insert(Persona persona);
    void modify(Persona persona);
    void delete(Persona persona);
}

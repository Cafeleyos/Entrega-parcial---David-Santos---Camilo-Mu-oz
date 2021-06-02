package sample.logic.services.implementation;

import javafx.collections.FXCollections;
import sample.logic.entities.Persona;
import sample.logic.persistence.IPersonaPersistence;
import sample.logic.persistence.implementation.PersonaPersistence;
import sample.logic.services.IPersonaServices;

import java.io.IOException;
import java.util.List;

public class PersonaServices implements IPersonaServices {
    private IPersonaPersistence personasDataBase;
    private List<Persona>personas;

    public PersonaServices() {
        personas = FXCollections.observableArrayList();
        try {
            personasDataBase = new PersonaPersistence();
            personas.addAll(personasDataBase.read());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int index() {
        System.out.println(personas.size());

        return personas.size();
    }

    public Persona findIndex(String id) {
        Persona result = null;
        int index = 0;


        for(index = 0; index < personas.size(); index++) {
            if(id.equals(personas.get(index).getId())) {
                result = personas.get(index);
                break;
            }
        }

        return result;
    }

    @Override
    public List<Persona> getAll() {
        return personas;
    }

    @Override
    public Persona insert(Persona persona) throws IOException {
        personas.add(persona);
        personasDataBase.save(persona);
        return persona;
    }

    @Override
    public void modify(Persona persona) {
    }

    @Override
    public void delete(Persona persona) {
        this.personas.remove(persona);
    }
}

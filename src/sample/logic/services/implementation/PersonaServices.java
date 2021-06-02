package sample.logic.services.implementation;

import javafx.collections.FXCollections;
import sample.logic.entities.Exportable;
import sample.logic.entities.Persona;
import sample.logic.persistence.IExport;
import sample.logic.persistence.IPersonaPersistence;
import sample.logic.persistence.implementation.Export;
import sample.logic.persistence.implementation.PersonaPersistence;
import sample.logic.services.IPersonaServices;
import sample.logic.services.PersonaException;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonaServices implements IPersonaServices {
    private IPersonaPersistence personasDataBase;
    private List<Persona>personas;
    private IExport export;

    public PersonaServices() {
        personas = FXCollections.observableArrayList();
        try {
            personasDataBase = new PersonaPersistence();
            personas.addAll(personasDataBase.read());
            this.export = new Export();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
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
    public Persona insert(Persona persona) throws IOException, PersonaException {
        boolean create = true;

        for (Persona p: personas){
            if (p.getId().equals(persona.getId())){
                create = false;
                break;
            }
        }
        if (create) {
            personas.add(persona);
            personasDataBase.save(persona, true);
        }
        if (!create) {
            throw new PersonaException(PersonaException.EQUAL_ID);
        }
        return persona;
    }

    @Override
    public void modify(Persona persona) {
    }

    @Override
    public void delete(Persona persona) {
        try {
            personasDataBase.save(persona, false);
            this.personas.remove(persona);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void export() throws FileNotFoundException {
        List<Exportable> exportableList = new ArrayList<>();
        this.personas.stream().forEach(p -> exportableList.add(p));
        this.export.export(exportableList, Exportable.CSV);
    }
}

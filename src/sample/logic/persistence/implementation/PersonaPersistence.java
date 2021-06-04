package sample.logic.persistence.implementation;

import sample.logic.entities.Persona;
import sample.logic.persistence.IPersonaPersistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaPersistence implements IPersonaPersistence, Serializable{
    private static final String PEOPLE_FILE_PATH = "people.database";
    private File file;
    private ObjectInputStream read;
    private ObjectOutputStream write;
    private List<Persona> data;

    public PersonaPersistence() throws IOException {
        file = new File(PEOPLE_FILE_PATH);
        if (file.createNewFile()) {
            System.out.println("The file "+ PEOPLE_FILE_PATH + " was created successfully");
        }
        data = new ArrayList<>();
    }

    @Override
    public void save(Persona persona, boolean option) throws IOException {
        if (option) {
            data.add(persona);
        } else {
            data.remove(persona);
        }
        write();
    }


    @Override
    public List<Persona> read() throws IOException, ClassNotFoundException {
            if(file.length() != 0) {
                read = new ObjectInputStream(new FileInputStream(PEOPLE_FILE_PATH));
                data.addAll((ArrayList<Persona>)read.readObject());
                read.close();
        }
        return data;
    }

    @Override
    public void replace(Persona newPersona,Persona personaToReplace) throws IOException {
            data.set(data.indexOf(personaToReplace),newPersona);
            write();
    }

    @Override
    public void write() throws IOException {
        write = new ObjectOutputStream(new FileOutputStream(PEOPLE_FILE_PATH));
        write.writeObject(data);
        write.close();
    }
}
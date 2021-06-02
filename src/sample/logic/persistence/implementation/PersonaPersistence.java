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
    public void save(Persona persona) throws IOException {
        try {
            write = new ObjectOutputStream(new FileOutputStream(PEOPLE_FILE_PATH));
            data.add(persona);
            write.writeObject(data);
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Persona> read() throws IOException, ClassNotFoundException {
            if(file.length() != 0) {
                read = new ObjectInputStream(new FileInputStream(PEOPLE_FILE_PATH));
                data.addAll((ArrayList<Persona>)read.readObject());
                System.out.println(data);
                read.close();
        }
        return data;
        }
    }


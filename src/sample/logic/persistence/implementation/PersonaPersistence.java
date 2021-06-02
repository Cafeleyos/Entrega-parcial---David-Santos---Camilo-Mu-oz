package sample.logic.persistence.implementation;

import sample.logic.entities.Persona;
import sample.logic.persistence.IPersonaPersistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaPersistence implements IPersonaPersistence, Serializable{
    private static final String PEOPLE_FILE_PATH = "people.database";

    public PersonaPersistence() throws IOException {
        File file = new File(PEOPLE_FILE_PATH);
        if (file.createNewFile()) {
            System.out.println("The file "+ PEOPLE_FILE_PATH + " was created successfully");
        }
    }

    @Override
    public void save(Persona persona) throws IOException {
        try {
            ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(PEOPLE_FILE_PATH, true));
            write.writeObject(persona);
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Persona> read() throws IOException {
        List<Persona> result = new ArrayList<>();
        FileInputStream input = new FileInputStream(PEOPLE_FILE_PATH);
        ObjectInputStream r = new ObjectInputStream(input);
        Object obj = null;
        while (r.available()>0){
            try {
                result.add((Persona) r.readObject());
                System.out.println(result);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}

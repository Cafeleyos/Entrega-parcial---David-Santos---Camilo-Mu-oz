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

    public PersonaPersistence() throws IOException {
        file = new File(PEOPLE_FILE_PATH);
        if (file.createNewFile()) {
            System.out.println("The file "+ PEOPLE_FILE_PATH + " was created successfully");
        }
        try {
            write = new ObjectOutputStream(new FileOutputStream(PEOPLE_FILE_PATH, true));
            if(file.length() != 0) {
                read = new ObjectInputStream(new FileInputStream(PEOPLE_FILE_PATH));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Persona persona) throws IOException {
        try {
            write.writeObject(persona);
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Persona> read() throws IOException, ClassNotFoundException {
        List<Persona> result = new ArrayList<>();

            if(file.length() != 0) {
                boolean counter = true;

                while (counter) {
                    try {
                        result.add((Persona) read.readObject());
                    } catch (EOFException e) {
                        break;
                    }
                }
                read.close();
        }

        return result;
        }

            /*while (r.available()>0){
                try {
                    result.add((Persona) r.readObject());
                    System.out.println(result);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;*/
    }


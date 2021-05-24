package sample.logic.persistence.implementation;

import sample.logic.entities.Person;
import sample.logic.persistence.IPersonaPersistence;

import java.io.*;
import java.util.List;

public class PersonaPersistence implements IPersonaPersistence {
    private static final String PEOPLE_FILE_PATH = "people.database";

    public PersonaPersistence() throws IOException {
        File file = new File(PEOPLE_FILE_PATH);
        if (file.createNewFile()) {
            System.out.println("The file "+ PEOPLE_FILE_PATH + " was created successfully");
        }
    }

    @Override
    public void save(Person person) throws IOException {
        ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(PEOPLE_FILE_PATH,true));
        write.writeObject(person);
        write.close();
    }

    @Override
    public List<Person> read()  throws IOException {
        ObjectInputStream read = new ObjectInputStream(new FileInputStream(PEOPLE_FILE_PATH));
        return null;
    }

    @Override
    public void export() {

    }
}

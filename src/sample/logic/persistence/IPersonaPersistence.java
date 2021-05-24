package sample.logic.persistence;

import sample.logic.entities.Person;

import java.io.IOException;
import java.util.List;

public interface IPersonaPersistence {
    void save(Person person) throws IOException;

    List<Person> read() throws IOException;

    void export();

}

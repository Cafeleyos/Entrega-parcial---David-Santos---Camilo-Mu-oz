package sample.logic.persistence.implementation;

import sample.gui.SetUp;
import sample.logic.persistence.PersistenceException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Import {
    SetUp setUp;
    public Import() {
        setUp = new SetUp();
    }

    public void verifyFileHeader(File file) throws IOException, PersistenceException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String header =br.readLine();
        ArrayList<String> readList = new ArrayList<>(Arrays.asList(header.split(",")));
        List<String> setUpList = setUp.stringList();


        for (int i = 0; i < setUp.stringList().size(); i++) {
            if(!(setUpList.contains(readList.get(i)))){
                throw new PersistenceException(PersistenceException.WRONG_IMPORT_HEADER);
            }
        }

    }
}

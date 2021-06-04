package sample.logic.persistence.implementation;

import sample.gui.SetUp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Import {
    public Import() {
        SetUp setUp = new SetUp();
    }

    public void verifyFileHeader(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String header =br.readLine();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(header.split(",")));

        for (String s: list){

        }

    }
}

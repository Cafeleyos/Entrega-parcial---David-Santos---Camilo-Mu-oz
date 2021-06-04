package sample.logic.entities;

import sample.gui.AddScene;
import sample.gui.SetUp;

import java.util.List;

public abstract class Exportable {

    public static final Character CSV = ',';
    public static final Character PCS = ';';
    public static final Character BSC = '|';

    public abstract List<String> toStringList();

    public abstract String getHeader(Character separateCharacter);

    public static String getExtension(Character characterSeparate) {
        return switch (characterSeparate) {
            case ',' -> "csv";
            case ';' -> "pcs";
            case '|' -> "bsc";
            default -> "";
        };
    }

    public String toExportValue(Character characterSeparate) {
        int count = 0;
        List<String> stringList = this.toStringList();
        StringBuilder stringBuilder = new StringBuilder();

        for(String s : stringList) {
            if(count < SetUp.NUMBER_OF_ITEMS-1) {
                stringBuilder.append(s).append(characterSeparate);
                count++;
            }
            else {
                stringBuilder.append(s);
                count = 0;
            }
        }

        return stringBuilder.toString();
    }
}

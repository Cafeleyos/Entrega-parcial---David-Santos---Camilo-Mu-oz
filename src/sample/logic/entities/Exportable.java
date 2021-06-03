package sample.logic.entities;

import java.util.List;

public abstract class Exportable {

    public static final Character CSV = ',';
    public static final Character PCS = ';';
    public static final Character BSC = '|';

    public abstract List<String> toListString();

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
        List<String> stringList = this.toListString();
        StringBuilder stringBuilder = new StringBuilder();

        for(String s : stringList) {
            stringBuilder.append(s).append(characterSeparate);
        }

        return stringBuilder.toString();
    }
}

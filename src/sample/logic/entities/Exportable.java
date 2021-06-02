package sample.logic.entities;

import java.util.List;

public abstract class Exportable {

    public static final Character CSV = ',';

    public abstract List<String> toListString();

    public abstract String getHeader();

    public static String getExtension(Character characterSeparate) {
        String result = "";

        result = "csv";

        return result;
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

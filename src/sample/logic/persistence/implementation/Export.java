package sample.logic.persistence.implementation;

import sample.logic.entities.Exportable;
import sample.logic.persistence.IExport;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class Export implements IExport {

    @Override
    public void export(List<Exportable> exportableList, Character characterSeparate) throws FileNotFoundException {
        LocalDate now = LocalDate.now();
        String hour = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());
        String minute = new SimpleDateFormat("mm").format(Calendar.getInstance().getTime());
        String second = new SimpleDateFormat("ss").format(Calendar.getInstance().getTime());

        String fileName = String.format("ExportPersons-%s-%s-%s_%s-%s-%s.%s", now.getYear(), now.getMonth(), now.getDayOfMonth(),
                hour, minute, second, Exportable.getExtension(characterSeparate));
        FileOutputStream out = new FileOutputStream(fileName);
        PrintWriter printWriter = new PrintWriter(out);

        String header = exportableList.stream().findAny().get().getHeader(characterSeparate);
        printWriter.println(header);

        for(Exportable e : exportableList) {
            String s = e.toExportValue(characterSeparate);
            printWriter.println(s);
        }
        printWriter.close();
    }
}
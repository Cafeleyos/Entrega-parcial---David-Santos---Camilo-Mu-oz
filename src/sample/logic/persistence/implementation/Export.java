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
        String minutes = new SimpleDateFormat("mm").format(Calendar.getInstance().getTime());
        String seconds = new SimpleDateFormat("ss").format(Calendar.getInstance().getTime());

        System.out.println(hour);

        String fileName = String.format("ExportPersons-%s-%s-%s_%s-%s-%s.%s", now.getYear(), now.getMonth(), now.getDayOfMonth(), hour, minutes, seconds, Exportable.getExtension(characterSeparate));
        FileOutputStream out = new FileOutputStream(fileName);
        PrintWriter printWriter = new PrintWriter(out);

        String header = exportableList.stream().findAny().get().getHeader();
        printWriter.println(header);
        System.out.println(header);

        for(Exportable e : exportableList) {
            String s = e.toExportValue(characterSeparate);
            printWriter.println(s);
            System.out.println(s);
        }
        printWriter.close();
    }
}
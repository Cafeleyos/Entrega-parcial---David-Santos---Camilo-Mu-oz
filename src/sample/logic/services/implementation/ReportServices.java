package sample.logic.services.implementation;

import sample.logic.DepartmentsEnum;
import sample.logic.entities.Persona;
import sample.logic.entities.Report;
import sample.logic.services.IPersonaServices;
import sample.logic.services.IReportServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportServices implements IReportServices {

    private IPersonaServices personaServices;

    public ReportServices() {

    }

    public ReportServices(IPersonaServices personaServices) {
        this.personaServices = personaServices;
    }

    @Override
    public Map<String, Report> getReportByDepartment() {
        List<Persona> personas = personaServices.getAll();
        Map<String, Report> reportMap = new HashMap<>();

        for(DepartmentsEnum departments : DepartmentsEnum.values()) {
            reportMap.put(departments.toString(), new Report(departments.toString(), 0, "Prueba"));
        }

        for(Persona p : personas) {
            reportMap.get(p.getDepartment()).incrementCount();
        }

        return reportMap;
    }

    @Override
    public Report getReportByAge() {
        return null;
    }
}

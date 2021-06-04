package sample.logic.services.implementation;

import sample.logic.DepartmentsEnum;
import sample.logic.entities.Persona;
import sample.logic.entities.Report;
import sample.logic.services.IPersonaServices;
import sample.logic.services.IReportServices;

import java.util.*;
import java.util.stream.Collectors;

public class ReportServices implements IReportServices {

    private IPersonaServices personaServices;

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
        List<Persona> personas = personaServices.getAll();
        Report report = new Report("edad", 0, "Porcentaje de Victimas\nMenores de Edad");

        for(Persona p : personas) {
            if(p.getAge() < 18) {
                report.incrementCount();
            }
        }

        report.setCount(report.getCount()*100/personaServices.getAll().size());

        return report;
    }

    @Override
    public Report getReportByMayorDepartment() {
        Report report = new Report("department", 0, "Departamento con más\nVictimas");
        Map<String, Report> reportMap = getReportByDepartment();



        return report;
    }

    @Override
    public Report getReportBySex() {
        Report report = new Report("sex", 0, "Relación entre\nHombres y Mujeres");
        List<Persona> personas = personaServices.getAll();

        for(Persona p : personas) {
            if(p.getSex().equals("Masculino")) {
                report.incrementCount();
            }
        }
        if(report.getCount() == personaServices.getAll().size()) {
            report.setCount(personaServices.getAll().size());
        }
        else if(report.getCount() != 0) {
            report.setCount(report.getCount()/(personas.size()-report.getCount()));
        }
        else {
            report.setCount(personas.size());
        }

        return report;
    }

    @Override
    public Report getReportByPositionCivil() {
        Report report = new Report("civil", 0, "Relación entre Civiles\ny Fuerzas Públicas");
        List<Persona> personas = personaServices.getAll();

        for(Persona p : personas) {
            if(p.getPosition().equals("Civil")) {
                report.incrementCount();
            }
        }

        report.setCount(report.getCount()/(personas.size()-report.getCount()));

        return report;
    }

    @Override
    public Report getReportByDeaths(boolean isCivil) {
        Report report = new Report("deaths", 0, "Cantidad de Civiles\nMuertos en el Paro");
        List<Persona> personas = personaServices.getAll();

        if(isCivil) {
            for(Persona p : personas) {
                if(p.getPosition().equals("Civil") && p.getCondition().equals("Muerto")) {
                    report.incrementCount();
                }
            }
        }
        else {
            report.setDescription("Cantidad de Muertes de\nEmpleados Públicos");
            for(Persona p : personas) {
                if(!p.getPosition().equals("Civil") && p.getCondition().equals("Muerto")) {
                    report.incrementCount();
                }
            }
        }


        return report;
    }
}

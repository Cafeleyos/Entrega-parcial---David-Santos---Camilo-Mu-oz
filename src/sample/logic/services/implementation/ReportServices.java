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
            reportMap.put(departments.toString(), new Report(departments.toString(), 0, "Departamento con más\nVictimas"));
        }
        for(Persona p : personas) {
            reportMap.get(p.getDepartment()).incrementCount();
        }

        return reportMap;
    }

    @Override
    public Report getReportByAge(boolean isMenor) {
        List<Persona> personas = personaServices.getAll();
        Report report = new Report("edad", 0, "Victimas Menores de\nEdad");

        if(isMenor) {
            for(Persona p : personas) {
                if(p.getAge() < 18) {
                    report.incrementCount();
                }
            }
        }
        else {
            for(Persona p : personas) {
                if(p.getAge() >= 18) {
                    report.incrementCount();
                }
            }
            report.setDescription("Victimas Mayores de\nEdad");
        }

        report.setCount(report.getCount()*100/personaServices.getAll().size());

        return report;
    }

    @Override
    public Report getReportByMayorDepartment() {
        Report report = new Report("department", 0, "Departamento con más\nVictimas");
        Map<String, Report> reportMap = getReportByDepartment();
        String department = "";
        double mayor = 0;

        for(DepartmentsEnum d : DepartmentsEnum.values()) {
            if(reportMap.get(d.toString()).getCount() >= mayor) {
                mayor = reportMap.get(d.toString()).getCount();
                department = d.toString();
            }
        }

        report.setInformation(department);
        report.setCount(mayor);

        return report;
    }

    @Override
    public Report getReportBySex(boolean isMen) {
        Report report = new Report("sex", 0, "Victimas de Sexo\nMasculino");
        List<Persona> personas = personaServices.getAll();

        if(isMen) {
            for(Persona p : personas) {
                if(p.getSex().equals("Masculino")) {
                    report.incrementCount();
                }
            }
        }
        else {
            for(Persona p : personas) {
                if(p.getSex().equals("Femenino")) {
                    report.incrementCount();
                }
            }
            report.setDescription("Victimas de Sexo\nFemenino");
        }

        report.setCount(report.getCount()*100/personaServices.getAll().size());

        return report;
    }

    @Override
    public Report getReportByPosition(boolean isCivil) {
        Report report = new Report("civil", 0, "Civiles que son\nVictimas");
        List<Persona> personas = personaServices.getAll();

        if(isCivil) {
            for(Persona p : personas) {
                if(p.getPosition().equals("Civil")) {
                    report.incrementCount();
                }
            }
        }
        else {
            report.setDescription("Empleados Públicos\nque son Victimas");
            for(Persona p : personas) {
                if(!p.getPosition().equals("Civil")) {
                    report.incrementCount();
                }
            }
        }

        report.setCount(report.getCount()*100/personaServices.getAll().size());

        return report;
    }

    @Override
    public Report getReportByDeaths(boolean isCivil) {
        Report report = new Report("deaths", 0, "Civiles Muertos en el\nParo");
        List<Persona> personas = personaServices.getAll();

        if(isCivil) {
            for(Persona p : personas) {
                if(p.getPosition().equals("Civil") && p.getCondition().equals("Muerto")) {
                    report.incrementCount();
                }
            }
        }
        else {
            report.setDescription("Empleados Públicos\nMuertos en el Paro");
            for(Persona p : personas) {
                if(!p.getPosition().equals("Civil") && p.getCondition().equals("Muerto")) {
                    report.incrementCount();
                }
            }
        }
        return report;
    }
}

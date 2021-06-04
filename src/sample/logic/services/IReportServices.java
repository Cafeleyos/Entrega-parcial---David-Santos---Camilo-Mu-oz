package sample.logic.services;

import sample.logic.entities.Report;

import java.util.List;
import java.util.Map;

public interface IReportServices {
    Map<String, Report> getReportByDepartment();
    Report getReportByAge();
    Report getReportByMayorDepartment();
    Report getReportBySex();
    Report getReportByPositionCivil();
    Report getReportByDeaths(boolean isCivil);
}

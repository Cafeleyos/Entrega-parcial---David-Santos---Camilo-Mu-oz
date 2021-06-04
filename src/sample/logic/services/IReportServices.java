package sample.logic.services;

import sample.logic.entities.Report;

import java.util.Map;

public interface IReportServices {
    Map<String, Report> getReportByDepartment();
    Report getReportByAge();
}

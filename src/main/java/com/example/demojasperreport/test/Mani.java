package com.example.demojasperreport.test;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Mani {

    public static void main(String[] args) {
        log.info("Start generate report");

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Michał", "Kuchciak", 26, "123123123"));
        customers.add(new Customer(1, "Elżbieta", "Kuchciak", 26, "321321321"));
        customers.add(new Customer(1, "Tomasz", "Kuchciak", 26, "543345543"));

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport("/Users/michalkuchciak/IdeaProjects/demo-jasper-report/src/main/resources/customer_report.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(customers));
            JasperExportManager.exportReportToPdfFile(jasperPrint, "/Users/michalkuchciak/IdeaProjects/demo-jasper-report/src/main/resources/customer_pdf.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }

        log.info("End generate report");
    }

}

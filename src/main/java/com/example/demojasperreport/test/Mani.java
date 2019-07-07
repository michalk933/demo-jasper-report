package com.example.demojasperreport.test;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Mani {

    public static void main(String[] args) {
        log.info("Start generate report");

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Michał", "Kuchciak", 26, "123123123", getOperations()));
        customers.add(new Customer(2, "Elżbieta", "Kuchciak", 26, "321321321", getOperations()));
        customers.add(new Customer(3, "Tomasz", "Kuchciak", 26, "543345543", getOperations()));

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("SUBREPORT_DIR", "/Users/michalkuchciak/IdeaProjects/demo-jasper-report/src/main/resources/");

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport("/Users/michalkuchciak/IdeaProjects/demo-jasper-report/src/main/resources/customer_report.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(customers));
            JasperExportManager.exportReportToPdfFile(jasperPrint, "/Users/michalkuchciak/IdeaProjects/demo-jasper-report/src/main/resources/customer2_pdf.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }

        log.info("End generate report");
    }

    private static List<Operations> getOperations() {
        List<Operations> operations = new ArrayList<>();
        operations.add(new Operations(1, new BigDecimal("123.12").toString(), LocalDate.now().toString(), "Jan Kowalski"));
        operations.add(new Operations(2, new BigDecimal("12324.12").toString(), LocalDate.now().toString(), "Aleksandra Szczęsny"));
        operations.add(new Operations(3, new BigDecimal("43123.12").toString(), LocalDate.now().toString(), "Tadeusz Konieczny"));
        return operations;
    }

}

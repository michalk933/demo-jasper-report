package com.example.demojasperreport.test.service.Impl;

import com.example.demojasperreport.test.aop.LogExecutionAop;
import com.example.demojasperreport.test.exception.JasperGenerateException;
import com.example.demojasperreport.test.service.GeneratePdfReportService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Service to generate pdf report
 * <p>
 * <p>
 * Create by Michał Kuchciak
 */
@Slf4j
@Service
class GeneratePdfReportServiceImpl implements GeneratePdfReportService {

    @LogExecutionAop
    @Override
    public void createReport(final Map<String, Object> params, final JRBeanCollectionDataSource dataSource, final String pathToJrxmlFile, final String pathToDestinationFile) {
        log.info("Start generate report");

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(pathToJrxmlFile);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, pathToDestinationFile);
        } catch (JRException e) {
            throw new JasperGenerateException("Error during generate report: ", e);
        }

        log.info("End generate report");
    }

}

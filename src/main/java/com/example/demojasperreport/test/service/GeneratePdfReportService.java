package com.example.demojasperreport.test.service;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.Map;

/**
 * Service to generate pdf report
 * <p>
 * <p>
 * Create by Michał Kuchciak
 */
public interface GeneratePdfReportService {

    /**
     * Method create report
     *
     * @param params                params needed to generate report
     * @param dataSource            JRBeanCollectionDataSource with list object to report
     * @param pathToJrxmlFile       path and file name jasper file (.jrxml)
     * @param pathToDestinationFile path to destination file report
     */
    void createReport(final Map<String, Object> params, final JRBeanCollectionDataSource dataSource, final String pathToJrxmlFile, final String pathToDestinationFile);

}

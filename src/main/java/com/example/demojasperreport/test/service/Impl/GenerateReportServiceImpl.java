package com.example.demojasperreport.test.service.Impl;

import com.example.demojasperreport.test.aop.LogExecutionAop;
import com.example.demojasperreport.test.domain.Customer;
import com.example.demojasperreport.test.repository.CustomerRepositoryMock;
import com.example.demojasperreport.test.repository.ParametersRepositoryMock;
import com.example.demojasperreport.test.service.GeneratePdfReportService;
import com.example.demojasperreport.test.service.GenerateReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service to generate report
 * <p>
 * <p>
 * Create by Michał Kuchciak
 */
@Slf4j
@Service
@RequiredArgsConstructor
class GenerateReportServiceImpl implements GenerateReportService {

    private final GeneratePdfReportService pdfReportService;

    private final CustomerRepositoryMock customerRepositoryMock;

    private final ParametersRepositoryMock parametersRepositoryMock;

    @LogExecutionAop
    @Override
    public void generateReport() {
        List<Customer> customer = customerRepositoryMock.getCustomer();
        Map<String, Object> params = parametersRepositoryMock.getParams();
        String pathToJrxmlFile = "/Users/michalkuchciak/IdeaProjects/demo-jasper-report/src/main/resources/customer_report.jrxml";
        String destinationFile = "/Users/michalkuchciak/IdeaProjects/demo-jasper-report/src/main/resources/customer_new_pdf.pdf";
        pdfReportService.createReport(params, new JRBeanCollectionDataSource(customer), pathToJrxmlFile, destinationFile);
    }

}

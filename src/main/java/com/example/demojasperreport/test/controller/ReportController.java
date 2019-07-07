package com.example.demojasperreport.test.controller;


import com.example.demojasperreport.test.service.GenerateReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
class ReportController {

    private final GenerateReportService service;

    @GetMapping(path = "/generatePdf")
    public void generate() {
        service.generateReport();
    }

}

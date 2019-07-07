package com.example.demojasperreport.test.repository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Temporary mock for params repository
 * <p>
 * Create by Michał Kuchciak
 */
@Slf4j
@Component
public class ParametersRepositoryMock {

    public Map<String, Object> getParams() {
        Map<String, Object> params = new HashMap<>();
        params.put("SUBREPORT_DIR", "/Users/michalkuchciak/IdeaProjects/demo-jasper-report/src/main/resources/");
        params.put("path", "/Users/michalkuchciak/IdeaProjects/demo-jasper-report/src/main/resources/");
        params.put("subreportName", "Operation_report.jasper");
        return params;
    }

}

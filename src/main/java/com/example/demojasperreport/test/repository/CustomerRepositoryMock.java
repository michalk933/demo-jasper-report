package com.example.demojasperreport.test.repository;

import com.example.demojasperreport.test.domain.Customer;
import com.example.demojasperreport.test.domain.Operations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Temporary mock for customer repository
 *
 *
 * Create by Michał Kuchciak
 */
@Slf4j
@Component
public class CustomerRepositoryMock {

    public List<Customer> getCustomer() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Michał", "Kuchciak", 26, "123123123", getOperations()));
        customers.add(new Customer(2, "Elżbieta", "Kuchciak", 26, "321321321", getOperations()));
        customers.add(new Customer(3, "Tomasz", "Kuchciak", 26, "543345543", getOperations()));
        return customers;
    }

    private List<Operations> getOperations() {
        List<Operations> operations = new ArrayList<>();
        operations.add(new Operations(1, new BigDecimal("123.12").toString(), LocalDate.now().toString(), "Jan Kowalski"));
        operations.add(new Operations(2, new BigDecimal("12324.12").toString(), LocalDate.now().toString(), "Aleksandra Szczęsny"));
        operations.add(new Operations(3, new BigDecimal("43123.12").toString(), LocalDate.now().toString(), "Tadeusz Konieczny"));
        return operations;
    }

}

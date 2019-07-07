package com.example.demojasperreport.test.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private int id;

    private String firstName;

    private String lastName;

    private int age;

    private String accountNumber;

    private List<Operations> operations;

}

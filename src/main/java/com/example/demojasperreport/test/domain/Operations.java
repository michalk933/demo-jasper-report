package com.example.demojasperreport.test.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operations {

    private int id;

    private String amount;

    private String date;

    private String recipientName;

}

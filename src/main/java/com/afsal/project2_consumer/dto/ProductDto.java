package com.afsal.project2_consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {


    private Integer id;

    private EmployeeDto employee;

    private Integer clientId;

    private String name;

    private String skuCode;

    private Boolean enable;

}

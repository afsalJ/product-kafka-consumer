package com.afsal.project2_consumer.util;


import com.afsal.project2_consumer.dto.ProductDto;
import com.afsal.project2_consumer.entity.Employee;
import com.afsal.project2_consumer.entity.Product;

public class ProductMapper {

    public static Product toEntity(ProductDto productDto){
        Product product = new Product();
        if(productDto.getId() != null) product.setId(productDto.getId());
        product.setEmployee(EmployeeMapper.toEntity(productDto.getEmployee()));
        product.setClientId(productDto.getClientId());
        product.setName(productDto.getName());
        product.setSkuCode(productDto.getSkuCode());
        product.setEnable(productDto.getEnable());
        return product;
    }


    public static String toString(Product product) {
        Employee employee = product.getEmployee();
        return product.getId() +
                "," + product.getName() +
                "," + product.getEnable() +
                "," + product.getClientId() +
                "," + product.getSkuCode() +
                ","+employee.getEmpId()+
                ","+employee.getName();
    }
}

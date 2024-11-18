package com.afsal.project2_consumer.util;


import com.afsal.project2_consumer.dto.EmployeeDto;
import com.afsal.project2_consumer.entity.Employee;

public class EmployeeMapper {

    public static Employee toEntity(EmployeeDto employeeDto){
        return new Employee(employeeDto.getEmpId(), employeeDto.getName());
    }

}

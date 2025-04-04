package com.employee.app.CRUD.Mapper;

import com.employee.app.CRUD.dto.EmployeeDto;
import com.employee.app.CRUD.entity.employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto (employee employee){
        return new  EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDate()
        );
    }

    public static employee mapToemployee (EmployeeDto employeeDto){
        return new employee(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.getEmail(),
                employeeDto.getDate()
        );
    }

}

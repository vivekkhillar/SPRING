package com.employee.app.CRUD.controller;

import com.employee.app.CRUD.dto.EmployeeDto;
import com.employee.app.CRUD.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/retrieveAllDatafromDB")
public class retriveAlldataFromDB {
    private EmployeeService employeeService;

    //Build retrieve all employee REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employees = employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }
}

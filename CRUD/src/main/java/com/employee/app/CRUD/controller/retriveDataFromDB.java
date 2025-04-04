package com.employee.app.CRUD.controller;

import com.employee.app.CRUD.dto.EmployeeDto;
import com.employee.app.CRUD.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/retrieveFromDB")
public class retriveDataFromDB {
    private EmployeeService employeeService;

    //Build retrieve employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long employeeId){

        EmployeeDto employeeDto = employeeService.getEmployee(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
}

package com.employee.app.CRUD.service.Implemantation;

import com.employee.app.CRUD.Mapper.EmployeeMapper;
import com.employee.app.CRUD.dto.EmployeeDto;
import com.employee.app.CRUD.entity.employee;
import com.employee.app.CRUD.exception.runtimeException;
import com.employee.app.CRUD.repository.EmployeeReposiotory;
import com.employee.app.CRUD.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {

    private EmployeeReposiotory employeeReposiotory;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        employee employee = EmployeeMapper.mapToemployee(employeeDto);
        employee savedEmployee =  employeeReposiotory.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee); //It might be changed
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {
        employee employee = employeeReposiotory.findById(employeeId)
                .orElseThrow(()->
                        new runtimeException("Employee Details not found" +" " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<employee> employees = employeeReposiotory.findAll();
        return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        employee employee = employeeReposiotory.findById(employeeId).orElseThrow(()->
                        new runtimeException("Employee Details not found" +" " + employeeId));
        employee.setFirstName(updatedEmployee.getFirstname());
        employee.setLastName(updatedEmployee.getLastname());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setDate(updatedEmployee.getDate());
        employee updatedEmployeeObj = employeeReposiotory.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employee employee = employeeReposiotory.findById(employeeId).orElseThrow(()->new runtimeException("Employee Not Found"));
        employeeReposiotory.deleteById(employeeId);
    }
}

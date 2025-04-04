package com.employee.app.CRUD.repository;

import com.employee.app.CRUD.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeReposiotory extends JpaRepository <employee, Long> {
    void deleteById(Long employeeId);
}

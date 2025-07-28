package com.romankrivtsov.spring.rest.dao;

import com.romankrivtsov.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void deleteEmployee(Employee employee);
}

package com.romankrivtsov.spring.rest.service;

import com.romankrivtsov.spring.rest.dao.EmployeeDAO;
import com.romankrivtsov.spring.rest.entity.Employee;
import com.romankrivtsov.spring.rest.exception.NotExistEmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        Employee employee = employeeDAO.getEmployeeById(id);
        if (employee == null) {
            throw new NotExistEmployeeException("Работника с ID = " + id + " не существует");
        }
        return employee;
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(getEmployeeById(id));
    }
}

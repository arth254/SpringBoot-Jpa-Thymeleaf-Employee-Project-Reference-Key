package com.aurosoft.employee.service;

import java.util.List;

import com.aurosoft.employee.entity.Employee;

public interface EmployeeService {

    List<Employee> listAllEmployees();

    Employee getEmployeeById(int id);

    void insertEmployee(Employee employee);

    void updateEmployee(Employee employee);

    int deleteEmployee(int id);
}

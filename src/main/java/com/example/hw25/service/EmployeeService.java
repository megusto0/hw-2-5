package com.example.hw25.service;

import com.example.hw25.exception.EmployeeAlreadyAddedException;
import com.example.hw25.exception.EmployeeNotFoundException;
import com.example.hw25.exception.EmployeeStorageIsFullException;
import com.example.hw25.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private static int SIZE = 5;
    private final List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public Employee addEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < SIZE) {
            employees.add(employee);
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();

    }

    public Employee removeEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (!employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();


    }

    public Employee findEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();

    }

    public List<Employee> getAll() {
        return Collections.unmodifiableList(employees);
    }
}

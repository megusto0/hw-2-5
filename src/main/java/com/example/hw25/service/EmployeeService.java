package com.example.hw25.service;

import com.example.hw25.exception.EmployeeAlreadyAddedException;
import com.example.hw25.exception.EmployeeNotFoundException;
import com.example.hw25.exception.EmployeeStorageIsFullException;
import com.example.hw25.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmployeeService {
    private static int SIZE = 5;
    private final Employee[] employees;

    public EmployeeService() {
        this.employees = new Employee[SIZE];
    }

    public Employee addEmployee(String name,
                                String surname) {
        Employee employee = new Employee(name, surname);
        int indexForAdd = -1;
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null & indexForAdd == -1) {
                indexForAdd = i;
            }
            if(Objects.equals(employee, employees[i])) {
                throw new EmployeeAlreadyAddedException();
            }
        }

        if(indexForAdd == -1) {
            throw new EmployeeStorageIsFullException();
        }
        return employees[indexForAdd] = employee;

    }
    public Employee removeEmployee(String name,
                                String surname) {
        Employee employee = new Employee(name, surname);
        for (int i = 0; i  < employees.length; i++) {
            if(employees.equals(employees[i])) {
                employees[i] = null;
                return employee;
            }
        }
        throw new EmployeeNotFoundException();

    }
    public Employee findEmployee(String name,
                                String surname) {

    }
}

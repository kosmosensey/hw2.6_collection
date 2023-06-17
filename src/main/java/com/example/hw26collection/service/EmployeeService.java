package com.example.hw26collection.service;

import com.example.hw26collection.exception.InvalidInputException;
import com.example.hw26collection.model.Employee;
import org.springframework.stereotype.Service;
import com.example.hw26collection.exception.EmployeeArrayIsFullException;
import com.example.hw26collection.exception.EmployeeAlreadyAddedException;
import com.example.hw26collection.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.*;


@Service
public class EmployeeService {

    private static final int MAX_SIZE = 12;
    private final Map<String, Employee> employees = new HashMap<>(MAX_SIZE);

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee addEmployee(Employee employee) {

        if (!isAlpha(employee.getFirstName()) && !isAlpha(employee.getLastName())) {
            throw new InvalidInputException();
        }

        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
        }
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeArrayIsFullException("Коллекция сотрудников переполнена");
        }
        employees.put(createKey(employee), employee);
        return employee;
    }


    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = employees.get(createKey(firstName, lastName));

        if (!(isAlpha(firstName) && !isAlpha(lastName))) {
            throw new InvalidInputException();
        }

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.remove(employee.getFullName());
    }


    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = employees.get(createKey(firstName, lastName));

        if (!isAlpha(firstName) && !isAlpha(lastName)) {
            throw new InvalidInputException();
        }

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.get(employee.getFullName());
    }

    private static String createKey(Employee employee) {
        return createKey(employee.getFirstName(), employee.getLastName());
    }

    private static String createKey(String firstName, String lastName) {
        return (firstName + lastName).toLowerCase();
    }
}
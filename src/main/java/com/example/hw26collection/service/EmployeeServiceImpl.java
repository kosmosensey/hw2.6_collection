package com.example.hw26collection.service;

import com.example.hw26collection.Employee;
import org.springframework.stereotype.Service;
import com.example.hw26collection.exception.EmployeeArrayIsFullException;
import com.example.hw26collection.exception.EmployeeAlreadyAddedException;
import com.example.hw26collection.exception.EmployeeNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {

    private final List<Employee> employee;

    public EmployeeServiceImpl() {
        this.employee = new ArrayList<>();
        employee.add(new Employee("Антон", "Вершинин"));
        employee.add(new Employee("Анна", "Миронова"));
        employee.add(new Employee("Владмир", "Горшков"));
        employee.add(new Employee("Антон", "Круг"));
        employee.add(new Employee("Александр", "Кузнецов"));
        employee.add(new Employee("Антон", "Морозов"));
        employee.add(new Employee("Антон", "Орлов"));
        employee.add(new Employee("Ирина", "Егорова"));
        employee.add(new Employee("Дмитрий", "Павлов"));
        employee.add(new Employee("Кирилл", "Васильев"));
    }

    public String employee() {
        return employee.toString();
    }

    @Override
    public String addEmployee(String firstName, String lastName) {
        Employee tempEmployee = new Employee(firstName, lastName);
        if (employee.contains(tempEmployee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
        }
        if (employee.size() >= 12) {
            throw new EmployeeArrayIsFullException("Коллекция сотрудников переполнена");
        }
        employee.add(tempEmployee);
        return tempEmployee.toString();
    }

    @Override
    public String removeEmployee(String firstName, String lastName) {
        Employee tempEmployee = new Employee(firstName, lastName);
        if (!employee.contains(tempEmployee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        employee.removeIf(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName));
        return tempEmployee.toString();
    }

    @Override
    public String findEmployee(String firstName, String lastName) {
        Employee tempEmployee = new Employee(firstName, lastName);
        if (!employee.contains(tempEmployee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return tempEmployee.toString();
    }
}

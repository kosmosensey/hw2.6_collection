package com.example.hw26collection.service;

import com.example.hw26collection.Employee;

public interface EmployeeServiceInterface {
    String employee();
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

}

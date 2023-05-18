package com.example.hw26collection.service;

public interface EmployeeServiceInterface {
    String employee();
    String addEmployee(String firstName, String lastName);

    String removeEmployee(String firstName, String lastName);

    String findEmployee(String firstName, String lastName);

}

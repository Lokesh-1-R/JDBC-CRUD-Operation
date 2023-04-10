package com.axis.JDBC;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static final Scanner sc = new Scanner(System.in);
    private static DataOperation dataOperation;

    static {
        try {
            dataOperation = new DataOperation();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        boolean flag = true;
        while(flag) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Select all employees");
            System.out.println("2. Insert a new employee");
            System.out.println("3. Update an existing employee");
            System.out.println("4. Delete an existing employee");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    getAllEmployees();
                    break;
                case 2:
                    insertEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    flag = false;
                    System.out.println("Exitted from application!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void getAllEmployees() {
        List<Employee> employees = dataOperation.getAllEmployees();
        if(employees.size() == 0) {
            System.out.println("No employees found.");
        } else {
            for(Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }

    private static void insertEmployee() {
    	 System.out.print("Enter employee ID: ");
         int empId = sc.nextInt();

        System.out.print("Enter employee name: ");
        String empName = sc.next();

        System.out.print("Enter employee age: ");
        int empAge = sc.nextInt();

        System.out.print("Enter employee salary: ");
        int empSalary = sc.nextInt();

        Employee emp = new Employee(empId, empName, empAge, empSalary);
        dataOperation.insertEmployee(emp);
        System.out.println("Employee added successfully.");
    }

    private static void updateEmployee() {
        System.out.print("Enter employee ID: ");
        int empId = sc.nextInt();

        System.out.print("Enter new employee name: ");
        String empName = sc.next();

        System.out.print("Enter new employee age: ");
        int empAge = sc.nextInt();

        System.out.print("Enter new employee salary: ");
        int empSalary = sc.nextInt();

        Employee emp = new Employee(empId, empName, empAge, empSalary);
        dataOperation.updateEmployee(emp);
        System.out.println("Employee updated successfully.");
    }

    private static void deleteEmployee() {
        System.out.print("Enter employee ID: ");
        int empId = sc.nextInt();

        dataOperation.deleteEmployee(empId);
        System.out.println("Employee deleted successfully.");
    }
}

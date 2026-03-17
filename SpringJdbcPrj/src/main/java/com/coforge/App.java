package com.coforge;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coforge.config.Appconfig;
import com.coforge.dao.EmployeeDaoInterface;
import com.coforge.entities.Employee;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        // Create the context using the configuration class
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class)) {
            EmployeeDaoInterface employeeDao = context.getBean(EmployeeDaoInterface.class);
            
            System.out.println("\n========== Inserting Employee ==========");
            Employee emp = new Employee(1234, "uday", 80000.0);
            employeeDao.insertEmployee(emp);
            System.out.println("Employee inserted successfully!");
            
            System.out.println("\n========== Displaying All Employees ==========");
            employeeDao.getAllEmployees().forEach(e -> System.out.println(e));
            
            System.out.println("\n========== Getting Employee by ID ==========");
            Employee empById = employeeDao.getEmployeebyId(1234);
            if (empById != null) {
                System.out.println("Employee Found: " + empById);
            } else {
                System.out.println("Employee not found!");
            }
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
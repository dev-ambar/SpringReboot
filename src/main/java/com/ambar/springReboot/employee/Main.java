package com.ambar.springReboot.employee;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

        public static void main(String[] args) {
            // List of Employee objects
            List<Employee> employees = Arrays.asList(
                    new Employee("John", 50000,25),
                    new Employee("Alice", 70000,45),
                    new Employee("Bob", 60000,18),
                    new Employee("David", 75000,76),
                    new Employee("David", 75000,76)
            );

            // Convert to a Map sorted by salary in descending order
/*           Map<Employee, Double> sortedMap = employees.stream()
                    .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())) // Sort by salary descending
                    .collect(Collectors.toMap(
                            e -> e,                       // Employee as key
                            Employee::getSalary,          // Salary as value
                            (existing, replacement) -> existing,  // Handle duplicates (not necessary in this case)
                            LinkedHashMap::new            // Collect into a LinkedHashMap to maintain the order
                    ));*/

            Comparator<? super Employee> compSalary = Comparator.comparingDouble(Employee::getSalary);

            Comparator<? super Employee> compAge = Comparator.comparingInt(Employee::getAge);

            Map<Employee, Double> sortedWithSalaryMap = employees.stream().sorted(compSalary).
                    collect(Collectors.toMap( e -> e, Employee::getSalary,(oldValue,newValue)-> oldValue,LinkedHashMap:: new));

            System.out.println("Print the sorted map with Salary ");

            sortedWithSalaryMap.forEach((employee, salary) -> System.out.println(employee + " -> " + salary));

            Map<Employee, Integer> sortedWithAgeMap = employees.stream().sorted(compAge).
                    collect(Collectors.toMap(e -> e,Employee::getAge,(oldValue,newValue)-> oldValue,LinkedHashMap:: new));
            // Print the sorted map
            System.out.println("Print the sorted map with Age  ");
            sortedWithAgeMap.forEach((employee, age) -> System.out.println(employee + " -> " + age));
        }

}

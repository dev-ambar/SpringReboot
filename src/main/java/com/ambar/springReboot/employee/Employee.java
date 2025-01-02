package com.ambar.springReboot.employee;

import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private Integer age ;

    public Employee(String name, double salary, Integer age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(age, employee.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, age);
    }
}



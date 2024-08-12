package com.learn.micro.module;


import java.util.ArrayList;
import java.util.List;

public class EmployeDeparment {

    private Department department;
    private List<Employee> employees = new ArrayList<>();

    public EmployeDeparment() {
    }

    public EmployeDeparment(Department department, List<Employee> employees) {
        this.department = department;
        this.employees = employees;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

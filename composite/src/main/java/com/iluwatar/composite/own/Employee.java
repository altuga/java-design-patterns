package com.iluwatar.composite.own;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class Employee {
    private String name;
    private double salary;

    private List<Employee> employeeList = new ArrayList<Employee>();

    private static HashMap<String, Double> salariesMap = new HashMap<String, Double>();

    public static HashMap<String, Double> getSalariesMap() {
        return salariesMap;
    }

    public static void setSalariesMap(HashMap<String, Double> salariesMap) {
        Employee.salariesMap = salariesMap;
    }

    public abstract void add(Employee employee);

    public abstract Employee getChild(int i);

    public abstract void print();




    public List<Employee> getEmployeeList() {
        return employeeList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

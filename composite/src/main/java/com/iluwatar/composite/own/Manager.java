package com.iluwatar.composite.own;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Manager extends Employee {

    private List<Employee> employeeList = new ArrayList<Employee>();
    double totalSalary = 0 ;


    public Manager(String name, double salary) {
        this.setName(name);
        this.setSalary(salary);

    }

    public void print() {
        System.out.println("-------------");
        System.out.println("Name ="+getName());
        System.out.println("Salary ="+getSalary());
        System.out.println("-------------");

        Iterator<Employee> employeeIterator = employeeList.iterator();
        while(employeeIterator.hasNext()){
            Employee employee = employeeIterator.next();
            employee.print();
        }
    }




    public void add(Employee employee) {
        employeeList.add(employee);
    }

    public Employee getChild(int i) {
        return getEmployeeList().get(i);
    }



}

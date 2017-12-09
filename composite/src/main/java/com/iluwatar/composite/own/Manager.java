package com.iluwatar.composite.own;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Manager extends Employee {

    private List<Employee> employeeList = new ArrayList<Employee>();


    public Manager(String name, double salary) {

        this.setName(name);
        this.setSalary(salary);

    }

    public  double getTotalSalary() {

        double total = 0;

        for (String key : getSalariesMap().keySet()) {
            total += getSalariesMap().get(key);
        }
        return  total;

    }

    public void reset() {
        getSalariesMap().clear();
    }



    public void print() {
        System.out.println("-------------");
        System.out.println("Name ="+getName());
        System.out.println("Salary ="+getSalary());
        System.out.println("-------------");

        addSalary(getName(), getSalary());

        Iterator<Employee> employeeIterator = employeeList.iterator();
        while(employeeIterator.hasNext()){
            Employee employee = employeeIterator.next();

            addSalary(employee.getName(), employee.getSalary());
            employee.print();
        }
    }


    private void addSalary(String name, Double salary) {
       Double salaryLocal = getSalariesMap().get(name);
       if (salaryLocal == null) {
           getSalariesMap().put(name, salary);
       }
    }


    public void add(Employee employee) {
        employeeList.add(employee);
    }

    public Employee getChild(int i) {
        return getEmployeeList().get(i);
    }



}

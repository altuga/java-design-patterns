package com.iluwatar.composite.own;

public class Coder extends Employee {



    public Coder(String name, double salary) {
        this.setName( name );
        this.setSalary(salary );

    }

    public void add(Employee employee) {
        // leaf
    }

    public Employee getChild(int i) {
        return null;
    }


    public void print() {
        System.out.println("-------------");
        System.out.println("Name ="+getName());
        System.out.println("Salary ="+getSalary());
        System.out.println("-------------");
    }


}

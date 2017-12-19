package com.iluwatar.composite.own;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Coder extends Employee {

    private static final Logger LOGGER = LoggerFactory.getLogger(Coder.class);

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
        LOGGER.info("-------------");
        LOGGER.info("Name ="+getName());
        LOGGER.info("Salary ="+getSalary());
        LOGGER.info("-------------");
    }


}

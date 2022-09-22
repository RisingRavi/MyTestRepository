package com.javatpoint.server.main.helloworld;

import io.swagger.models.auth.In;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Employee {
    /**
     *  Employee Id
     */
    Integer id;
    /**
     *  Employee Name
     */
    String name;
    /**
     *  Employee City
     */
    String city;
    /**
     *  Employee Salary
     */
    Integer salary;

    Marks marks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}

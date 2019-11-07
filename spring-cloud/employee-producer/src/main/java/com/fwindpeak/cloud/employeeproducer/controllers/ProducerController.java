package com.fwindpeak.cloud.employeeproducer.controllers;

import com.fwindpeak.cloud.employeeproducer.model.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProducerController {

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getDataFallBack")
    public Employee firstPage() {

        System.out.println("Inside firstPage");


        Employee emp = new Employee();
        emp.setName("emp2");
        emp.setDesignation("manager");
        emp.setEmpId("1");
        emp.setSalary(3000);
        if (emp.getName().equalsIgnoreCase("emp1"))
            throw new RuntimeException();

        return emp;
    }

    public Employee getDataFallBack() {

        System.out.println("Inside getDataFallBack");


        Employee emp = new Employee();
        emp.setName("fallback-emp1");
        emp.setDesignation("fallback-manager");
        emp.setEmpId("fallback-1");
        emp.setSalary(3000);

        return emp;

    }

}
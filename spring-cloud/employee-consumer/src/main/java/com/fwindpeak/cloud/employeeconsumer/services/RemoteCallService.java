package com.fwindpeak.cloud.employeeconsumer.services;

import com.fwindpeak.cloud.employeeconsumer.model.Employee;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "EMPLOYEE-ZUUL-SERVICE")
public interface RemoteCallService {
    @RequestMapping(method = RequestMethod.GET, value = "/producer/employee")
    public Employee getData();

}
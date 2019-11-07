package com.fwindpeak.cloud.employeeconsumer.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fwindpeak.cloud.employeeconsumer.model.Employee;
import com.fwindpeak.cloud.employeeconsumer.services.RemoteCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

public class ConsumerControllerClient {

    @Autowired
    private RemoteCallService loadBalancer;

    public void getEmployee() throws RestClientException, IOException {

        try {
            Employee emp = loadBalancer.getData();
            System.out.println(emp.getEmpId());
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValueAsString(emp);
            System.out.println(mapper.writeValueAsString(emp));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }
}
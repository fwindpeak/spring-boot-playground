package com.fwindpeak.cloud.employeeconsumer;

import com.fwindpeak.cloud.employeeconsumer.controllers.ConsumerControllerClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EnableFeignClients
public class EmployeeConsumerApplication {

    public static void main(String[] args) throws RestClientException, IOException {
        ApplicationContext ctx = run(EmployeeConsumerApplication.class, args);
        ConsumerControllerClient consumerControllerClient = ctx.getBean(ConsumerControllerClient.class);
//        System.out.println(consumerControllerClient);
        for (int i = 0; i < 2; i++)
            consumerControllerClient.getEmployee();
    }

    @Bean
    public ConsumerControllerClient consumerControllerClient() {
        return new ConsumerControllerClient();
    }

}

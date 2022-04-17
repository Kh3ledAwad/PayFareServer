package com.payment.payfareserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.payment.payfareserver")
public class PayFareServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayFareServerApplication.class, args);
    }

}

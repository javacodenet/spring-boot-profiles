package com.javacodenet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Application {

    @Autowired
    GenericConfiguration genericConfiguration;

    @Value("${profileSpecificMessage}")
    private String profileSpecificMessage;

    @Value("${defaultProfileMessage}")
    private String defaultProfileMessage;

    @RequestMapping("/")
    public String profiles() {
        return genericConfiguration.configurationMessage() + ", default profile message: " + defaultProfileMessage +
                ", profile specific message: " + profileSpecificMessage;
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        //this will add profile to existing set of profiles
        springApplication.setAdditionalProfiles("default");
        SpringApplication.run(Application.class, args);
    }
}
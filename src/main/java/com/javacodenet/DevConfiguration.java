package com.javacodenet;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"development"})
@Component
public class DevConfiguration implements GenericConfiguration {

    @Override
    public String configurationMessage() {
        return "Development Configuration Message";
    }
}

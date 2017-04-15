package com.javacodenet;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"production", "default"})
@Component
public class ProdConfiguration implements GenericConfiguration {

    @Override
    public String configurationMessage() {
        return "Production Configuration Message";
    }
}

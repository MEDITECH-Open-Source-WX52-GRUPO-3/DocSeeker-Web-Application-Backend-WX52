package com.meditech.docseeker.healing.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("healingMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public NewMapper newMapper(){
        return new NewMapper();
    }
}

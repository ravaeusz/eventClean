package com.evenClean.infra.beans;

import com.evenClean.core.gateway.EventGateway;
import com.evenClean.core.usecases.EventCreateUseCase;
import com.evenClean.core.usecases.EventCreateUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public EventCreateUseCase eventCreateUseCase(EventGateway eventGateway){
        return new EventCreateUseCaseImpl(eventGateway);
    }
}

package com.evenClean.infra.beans;

import com.evenClean.core.gateway.EventGateway;
import com.evenClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public EventCreateUseCase eventCreateUseCase(EventGateway eventGateway){
        return new EventCreateUseCaseImpl(eventGateway);
    }

    @Bean
    public EventGetUseCase eventGetUseCase(EventGateway eventGateway){
        return new EventGetUseCaseImpl(eventGateway);
    }

    @Bean
    public IdentificationGetUseCase identificationGetUseCase(EventGateway eventGateway){
        return new IdentificationGetUseCaseImpl(eventGateway);
    }

    @Bean
    public GenerateRandomIdentificationUseCase generateRandomIdentificationUseCase(EventGateway eventGateway){
        return new GenerateRandomIdentificationUseCaseImpl(eventGateway);
    }
}

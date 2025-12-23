package com.evenClean.infra.beans;

import com.evenClean.core.gateway.EventGateway;
import com.evenClean.core.usecases.EventCreateUseCase;
import com.evenClean.core.usecases.EventCreateUseCaseImpl;
import com.evenClean.core.usecases.EventGetUseCase;
import com.evenClean.core.usecases.EventGetUseCaseImpl;
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
}

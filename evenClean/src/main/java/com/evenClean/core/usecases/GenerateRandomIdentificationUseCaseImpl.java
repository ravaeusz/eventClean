package com.evenClean.core.usecases;

import com.evenClean.core.gateway.EventGateway;

public class GenerateRandomIdentificationUseCaseImpl implements GenerateRandomIdentificationUseCase{

    private final EventGateway eventGateway;

    public GenerateRandomIdentificationUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public String execute() {
        return eventGateway.generateIdentification();
    }
}


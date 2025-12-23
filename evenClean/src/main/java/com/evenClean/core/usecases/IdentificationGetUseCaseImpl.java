package com.evenClean.core.usecases;

import com.evenClean.core.entities.Event;
import com.evenClean.core.gateway.EventGateway;

import java.util.List;

public class IdentificationGetUseCaseImpl implements IdentificationGetUseCase{

    private final EventGateway eventGateway;

    public IdentificationGetUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identification) {
        return eventGateway.getIdentificador(identification);
    }
}

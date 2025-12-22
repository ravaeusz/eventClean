package com.evenClean.core.usecases;

import com.evenClean.core.entities.Event;
import com.evenClean.core.gateway.EventGateway;

public class EventCreateUseCaseImpl implements EventCreateUseCase {


    private final EventGateway eventGateway;

    public EventCreateUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        return eventGateway.eventCreate(event);
    }
}

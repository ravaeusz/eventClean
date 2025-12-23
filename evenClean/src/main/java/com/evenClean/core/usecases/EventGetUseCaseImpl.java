package com.evenClean.core.usecases;


import com.evenClean.core.entities.Event;
import com.evenClean.core.gateway.EventGateway;

import java.util.List;

public class EventGetUseCaseImpl implements EventGetUseCase {

    private final EventGateway eventGateway;

    public EventGetUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public List<Event> execute() {
        return eventGateway.eventGet();
    }
}

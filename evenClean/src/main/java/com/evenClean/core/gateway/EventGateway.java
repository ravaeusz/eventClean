package com.evenClean.core.gateway;


import com.evenClean.core.entities.Event;

import java.util.List;

public interface EventGateway {

    Event eventCreate(Event event);
    List<Event> eventGet();

}

package com.evenClean.infra.mapper;
import com.evenClean.core.entities.Event;
import com.evenClean.infra.dto.EventDTO;

import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventDTO toDTO(Event event){
        return EventDTO.builder()
                .id(event.id())
                .name(event.name())
                .description(event.description())
                .dateInitial(event.dateInitial())
                .dateFinal(event.dateFinal())
                .identification(event.identification())
                .localEvent(event.localEvent())
                .capacity(event.capacity())
                .organization(event.organization())
                .type(event.type())
                .build();
    }

    public Event toEntity(EventDTO EventDTO){
        return new Event(
                EventDTO.id(),
                EventDTO.name(),
                EventDTO.description(),
                EventDTO.dateInitial(),
                EventDTO.dateFinal(),
                EventDTO.identification(),
                EventDTO.localEvent(),
                EventDTO.capacity(),
                EventDTO.organization(),
                EventDTO.type());
    }

}

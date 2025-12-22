package com.evenClean.infra.mapper;

import com.evenClean.core.entities.Event;
import com.evenClean.infra.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {

    public EventEntity toEntity(Event event){
        return new EventEntity(
                event.id(),
                event.name(),
                event.description(),
                event.dateInitial(),
                event.dateFinal(),
                event.identification(),
                event.localEvent(),
                event.capacity(),
                event.organization(),
                event.type()
        );
    }

    public Event toDomain(EventEntity eventEntity){
        return new Event(
                eventEntity.getId(),
                eventEntity.getName(),
                eventEntity.getDescription(),
                eventEntity.getDateInitial(),
                eventEntity.getDateFinal(),
                eventEntity.getIdentification(),
                eventEntity.getLocalEvent(),
                eventEntity.getCapacity(),
                eventEntity.getOrganization(),
                eventEntity.getType()
        );
    }

}

package com.evenClean.infra.mapper;
import com.evenClean.infra.dto.response.EventResponse;
import com.evenClean.infra.persistence.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventResponse toResponse(Event event){
        return EventResponse.builder()
                .id(event.getId())
                .name(event.getName())
                .description(event.getDescription())
                .dateInitial(event.getDateInitial())
                .dateFinal(event.getDateFinal())
                .identification(event.getIdentification())
                .localEvent(event.getLocalEvent())
                .capacity(event.getCapacity())
                .organization(event.getOrganization())
                .type(event.getType())
                .build();
    }

    public Event toEntity(EventResponse EventResponse){
        return Event.builder()
                .id(EventResponse.id())
                .name(EventResponse.name())
                .description(EventResponse.description())
                .dateInitial(EventResponse.dateInitial())
                .dateFinal(EventResponse.dateFinal())
                .identification(EventResponse.identification())
                .localEvent(EventResponse.localEvent())
                .capacity(EventResponse.capacity())
                .organization(EventResponse.organization())
                .type(EventResponse.type())
                .build();
    }

}

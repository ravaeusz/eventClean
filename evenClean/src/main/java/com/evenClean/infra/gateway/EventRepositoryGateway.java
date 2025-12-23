package com.evenClean.infra.gateway;

import com.evenClean.core.entities.Event;
import com.evenClean.core.gateway.EventGateway;
import com.evenClean.infra.exceptions.DuplicatedException;
import com.evenClean.infra.mapper.EventEntityMapper;
import com.evenClean.infra.persistence.EventEntity;
import com.evenClean.infra.persistence.EventRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository repository;
    private final EventEntityMapper eventEntityMapper;

    public EventRepositoryGateway(EventRepository repository, EventEntityMapper eventEntityMapper) {
        this.repository = repository;
        this.eventEntityMapper = eventEntityMapper;
    }

    @Override
    public Event eventCreate(Event event) {
        EventEntity saved = repository.save(eventEntityMapper.toEntity(event));
        return eventEntityMapper.toDomain(saved);
    }


    @Override
    public List<Event> getEvent() {
       return repository.findAll().stream().map(eventEntityMapper::toDomain).toList();
    }


    @Override
    public Event getIdentificador(String identification) {
        EventEntity id = repository.findByIdentification(identification);
        return eventEntityMapper.toDomain(id);
    }
}

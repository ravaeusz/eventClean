package com.evenClean.infra.gateway;

import com.evenClean.core.entities.Event;
import com.evenClean.core.gateway.EventGateway;;
import com.evenClean.infra.mapper.EventEntityMapper;
import com.evenClean.infra.persistence.EventEntity;
import com.evenClean.infra.persistence.EventRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

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
        if (id == null) {
            return null;
        }
        return eventEntityMapper.toDomain(id);
    }

    @Override
    public String generateIdentification() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


    }


}

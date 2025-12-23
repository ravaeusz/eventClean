package com.evenClean.infra.presentation;

import com.evenClean.core.entities.Event;
import com.evenClean.core.usecases.EventCreateUseCase;
import com.evenClean.core.usecases.EventGetUseCase;
import com.evenClean.core.usecases.IdentificationGetUseCase;
import com.evenClean.infra.dto.EventDTO;
import com.evenClean.infra.exceptions.DuplicatedException;
import com.evenClean.infra.exceptions.NotFoundException;
import com.evenClean.infra.mapper.EventMapper;
import com.evenClean.infra.persistence.EventEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class EventController {

    private final EventCreateUseCase eventCreateUseCase;
    private final EventGetUseCase eventGetUseCase;
    private final IdentificationGetUseCase identificationGetUseCase;
    private final EventMapper eventMapper;

    public EventController(EventCreateUseCase eventCreateUseCase, EventGetUseCase eventGetUseCase, IdentificationGetUseCase identificationGetUseCase, EventMapper eventMapper) {
        this.eventCreateUseCase = eventCreateUseCase;
        this.eventGetUseCase = eventGetUseCase;
        this.identificationGetUseCase = identificationGetUseCase;
        this.eventMapper = eventMapper;
    }

    @PostMapping("event")
    public ResponseEntity<HashMap<String, Object>> eventCreate(@RequestBody EventDTO dto){
        Event event = eventMapper.toEntity(dto);
        Event filter =  identificationGetUseCase.execute(event.identification());

        if (filter != null){
            throw new DuplicatedException("Evento com o mesmo identificador " +dto.identification()+ " já existe");
        }

        Event newEvent = eventCreateUseCase.execute(event);
        HashMap<String, Object> response = new HashMap<>();
        response.put("message","Cadastrado com sucesso!");
        response.put("data", eventMapper.toDTO(newEvent));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("event")
    public ResponseEntity<List<EventDTO>> getEvent(){
        List<Event> events = eventGetUseCase.execute();
        List<EventDTO> eventDTOS = events.stream().map(eventMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok().body(eventDTOS);
    }

    @GetMapping("event/{identification}")
    public ResponseEntity<HashMap<String, Object>> getIdentification(@PathVariable String identification){
        Event event = identificationGetUseCase.execute(identification);

        if (event != null){
            HashMap<String, Object> response = new HashMap<>();
            response.put("message","Evento com identificador: " +identification+ " encontrado com sucesso");
            response.put("data", eventMapper.toDTO(event));
            return ResponseEntity.ok().body(response);
        }

        throw new NotFoundException("Evento não encontrado");

    }
}

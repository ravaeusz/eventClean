package com.evenClean.infra.presentation;

import com.evenClean.core.entities.Event;
import com.evenClean.core.usecases.EventCreateUseCase;
import com.evenClean.core.usecases.EventGetUseCase;
import com.evenClean.infra.dto.EventDTO;
import com.evenClean.infra.mapper.EventMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EventController {

    private final EventCreateUseCase eventCreateUseCase;
    private final EventGetUseCase eventGetUseCase;
    private final EventMapper eventMapper;

    public EventController(EventCreateUseCase eventCreateUseCase, EventGetUseCase eventGetUseCase, EventMapper eventMapper) {
        this.eventCreateUseCase = eventCreateUseCase;
        this.eventGetUseCase = eventGetUseCase;
        this.eventMapper = eventMapper;
    }

    @PostMapping("create_event")
    public EventDTO eventCreate(@RequestBody EventDTO dto){
        Event newEvent = eventCreateUseCase.execute(eventMapper.toEntity(dto));
        return eventMapper.toDTO(newEvent);

    }

    @GetMapping("get-event")
    public String eventGet(){
        return "";
    }
}

package com.evenClean.infra.presentation;

import com.evenClean.core.entities.Event;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EventController {

    @PostMapping("create_event")
    public String eventCreate(@RequestBody Event event){
        return "Event created";
    }
}

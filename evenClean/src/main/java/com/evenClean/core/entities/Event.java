package com.evenClean.core.entities;

import com.evenClean.core.enums.EventType;

import java.time.LocalDateTime;


public record Event(
                    Long id,
                    String name,
                    String description,
                    LocalDateTime dateInitial,
                    LocalDateTime dateFinal,
                    String identification,
                    String localEvent,
                    Integer capacity,
                    String organization,
                    EventType type
                    ) { }

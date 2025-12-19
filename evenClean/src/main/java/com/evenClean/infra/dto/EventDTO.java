package com.evenClean.infra.dto;

import com.evenClean.core.enums.EventType;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EventDTO(
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
package com.evenClean.infra.persistence;

import com.evenClean.core.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "EVENTS")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime dateInitial;
    private LocalDateTime dateFinal;
    private String identification;
    private String localEvent;
    private Integer capacity;
    private String organization;
    @Enumerated(EnumType.STRING)
    private EventType type;

}

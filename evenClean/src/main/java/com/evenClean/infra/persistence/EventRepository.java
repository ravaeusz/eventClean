package com.evenClean.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    public EventEntity findByIdentification(String identification);

}

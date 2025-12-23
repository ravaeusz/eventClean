package com.evenClean.core.usecases;

import com.evenClean.core.entities.Event;

import java.util.List;

public interface IdentificationGetUseCase {

    public Event execute(String identification);
}

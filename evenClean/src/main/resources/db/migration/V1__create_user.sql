CREATE TABLE EVENTS  (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        description VARCHAR(255),
        date_initial TIMESTAMP NOT NULL,
        date_final TIMESTAMP NOT NULL,
        identification VARCHAR(255) NOT NULL UNIQUE,
        local_event VARCHAR(255) NOT NULL,
        capacity INTEGER NOT NULL,
        organization VARCHAR(255) NOT NULL,
        type VARCHAR(255) NOT NULL
);


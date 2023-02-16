package de.deroq.restapi.exception;

import jakarta.persistence.EntityNotFoundException;

/**
 * @author Miles
 * @since 16.02.2023
 */
public class ClanNotFoundException extends EntityNotFoundException {

    public ClanNotFoundException(String message) {
        super(message);
    }
}

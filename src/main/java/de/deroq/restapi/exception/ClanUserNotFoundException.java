package de.deroq.restapi.exception;

import jakarta.persistence.EntityNotFoundException;

/**
 * @author Miles
 * @since 16.02.2023
 */
public class ClanUserNotFoundException extends EntityNotFoundException {

    public ClanUserNotFoundException(String message) {
        super(message);
    }
}

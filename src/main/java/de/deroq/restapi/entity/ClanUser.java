package de.deroq.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author Miles
 * @since 16.02.2023
 */
@Entity(name = "clan_users")
public class ClanUser {

    @Id
    @Column(name = "player")
    private String uuid;
    private String name;
    private String clan;
    private String locale;

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getClan() {
        return clan;
    }

    public String getLocale() {
        return locale;
    }
}

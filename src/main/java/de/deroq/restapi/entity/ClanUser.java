package de.deroq.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

/**
 * @author Miles
 * @since 16.02.2023
 */
@Entity(name = "clan_users")
@Getter
public class ClanUser {

    @Id
    @Column(name = "player")
    private String uuid;
    private String name;
    private String clan;
    private String locale;
}

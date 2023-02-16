package de.deroq.restapi.repository;

import de.deroq.restapi.entity.Clan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Miles
 * @since 15.02.2023
 */
public interface ClanRepository extends JpaRepository<Clan, UUID> {

    /**
     * Deletes a clan by its id.
     *
     * @param id The id of the clan.
     * @return the clan which got deleted.
     */
    Clan deleteClanById(String id);

    /**
     * Deletes a clan by its name.
     *
     * @param name The name of the clan.
     * @return the clan which got deleted.
     */
    Clan deleteClanByClanName(String name);

    /**
     * Deletes a clan by its tag.
     *
     * @param tag The tag of the clan.
     * @return the clan which got deleted.
     */
    Clan deleteClanByClanTag(String tag);

    /**
     * Gets a clan by its id.
     *
     * @param id The id of the clan.
     * @return the Clan with the id {@code id} or null if not found.
     */
    Clan findClanById(String id);

    /**
     * Gets a clan by its name.
     *
     * @param name The name of the clan.
     * @return the Clan with the name {@code name} or null if not found.
     */
    Clan findClanByClanName(String name);

    /**
     * Gets a clan by its tag.
     *
     * @param tag The tag of the clan.
     * @return the Clan with the tag {@code tag} or null if not found.
     */
    Clan findClanByClanTag(String tag);
}

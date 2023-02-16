package de.deroq.restapi.repository;

import de.deroq.restapi.entity.Clan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Miles
 * @since 15.02.2023
 */
public interface ClanRepository extends JpaRepository<Clan, UUID> {

    Clan deleteClanById(String id);

    Clan deleteClanByClanName(String name);

    Clan deleteClanByClanTag(String tag);

    Clan findClanById(String id);

    Clan findClanByClanName(String name);

    Clan findClanByClanTag(String tag);
}

package de.deroq.restapi.repository;

import de.deroq.restapi.entity.ClanUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Miles
 * @since 16.02.2023
 */
public interface ClanUserRepository extends JpaRepository<ClanUser, String> {

    ClanUser deleteClanUserByUuid(String uuid);

    ClanUser deleteClanUserByName(String name);

    ClanUser findClanUserByUuid(String uuid);

    ClanUser findClanUserByName(String name);

    List<ClanUser> findClanUsersByClan(String clan);
}

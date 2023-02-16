package de.deroq.restapi.repository;

import de.deroq.restapi.entity.ClanUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Miles
 * @since 16.02.2023
 */
public interface ClanUserRepository extends JpaRepository<ClanUser, String> {

    /**
     * Deletes a user by its uuid.
     *
     * @param uuid The uuid of the user.
     * @return the ClanUser which got deleted.
     */
    ClanUser deleteClanUserByUuid(String uuid);

    /**
     * Deletes a user by its name.
     *
     * @param name The name of the user.
     * @return the ClanUser which got deleted.
     */
    ClanUser deleteClanUserByName(String name);

    /**
     * Gets a user by its uuid.
     *
     * @param uuid The uuid of the user.
     * @return the ClanUser with the uuid {@code uuid} or null if not found.
     */
    ClanUser findClanUserByUuid(String uuid);

    /**
     * Gets a user by its name.
     *
     * @param name The name of the user.
     * @return the ClanUser with the name {@code name} or null if not found.
     */
    ClanUser findClanUserByName(String name);

    /**
     * Gets all users by its clan.
     *
     * @param clan The id of the clan.
     * @return a List of ClanUsers who are in the clan with the id {@code clan}.
     */
    List<ClanUser> findClanUsersByClan(String clan);
}

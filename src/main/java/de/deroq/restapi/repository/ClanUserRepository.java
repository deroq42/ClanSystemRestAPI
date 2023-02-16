package de.deroq.restapi.repository;

import de.deroq.restapi.entity.ClanUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Miles
 * @since 16.02.2023
 */
public interface ClanUserRepository extends JpaRepository<ClanUser, String> {
}

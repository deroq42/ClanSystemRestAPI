package de.deroq.restapi.controller;

import de.deroq.restapi.entity.ClanUser;
import de.deroq.restapi.repository.ClanUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Miles
 * @since 16.02.2023
 */
@RestController
@RequestMapping("/clans/user")
public class ClanUserController {

    private final ClanUserRepository repository;

    public ClanUserController(ClanUserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/delete/uuid/{uuid}")
    public ClanUser deleteUserByUUID(@PathVariable String uuid) {
        return repository.deleteClanUserByUuid(uuid);
    }

    @PostMapping("/delete/name/{name}")
    public ClanUser deleteUserName(@PathVariable String name) {
        return repository.deleteClanUserByName(name);
    }

    @GetMapping("/get/uuid/{uuid}")
    public ClanUser getUserByUUID(@PathVariable String uuid) {
        return repository.findClanUserByUuid(uuid);
    }

    @GetMapping("/get/name/{name}")
    public ClanUser getUserByName(@PathVariable String name) {
        return repository.findClanUserByName(name);
    }

    @GetMapping("/get/clan/{clan}")
    public List<ClanUser> getUsersWithClan(@PathVariable String clan) {
        return repository.findClanUsersByClan(clan);
    }

    /**
     * Gets all users.
     *
     * @return a List of all ClanUsers.
     */
    @GetMapping("/all")
    public List<ClanUser> getUsers() {
        return repository.findAll();
    }
}

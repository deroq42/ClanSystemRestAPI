package de.deroq.restapi.controller;

import de.deroq.restapi.entity.ClanUser;
import de.deroq.restapi.exception.ClanUserNotFoundException;
import de.deroq.restapi.repository.ClanUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Miles
 * @since 16.02.2023
 */
@RestController
@RequestMapping("/users")
public class ClanUserController {

    private final ClanUserRepository repository;

    public ClanUserController(ClanUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/uuid/{uuid}")
    public ClanUser getUserByUUID(@PathVariable String uuid) {
        return getUsers().stream()
                .filter(user -> user.getUuid().equals(uuid))
                .findFirst()
                .orElseThrow(() -> new ClanUserNotFoundException("User with uuid " + uuid + " was not found"));
    }

    @GetMapping("/name/{name}")
    public ClanUser getUserByName(@PathVariable String name) {
        return getUsers().stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ClanUserNotFoundException("User with name " + name + " was not found"));
    }

    @GetMapping("/clan/{clan}")
    public Map<String, String> getUsersWithClan(@PathVariable String clan) {
        return getUsers().stream()
                .filter(user -> user.getClan() != null)
                .filter(user -> user.getClan().equals(clan))
                .collect(Collectors.toMap(ClanUser::getUuid, ClanUser::getName));
    }

    @GetMapping("/all")
    public List<ClanUser> getUsers() {
        return repository.findAll();
    }
}

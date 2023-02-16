package de.deroq.restapi.controller;

import de.deroq.restapi.entity.Clan;
import de.deroq.restapi.exception.ClanNotFoundException;
import de.deroq.restapi.repository.ClanRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Miles
 * @since 15.02.2023
 */
@RestController
@RequestMapping("/clans")
public class ClanController {

    private final ClanRepository repository;

    public ClanController(ClanRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/id/{id}")
    public Clan getClanById(@PathVariable String id) {
        return getClans()
                .stream()
                .filter(clan -> clan.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ClanNotFoundException("Clan with id " + id + " was not found"));
    }

    @GetMapping("/name/{name}")
    public Clan getClanByName(@PathVariable String name) {
        return getClans()
                .stream()
                .filter(clan -> clan.getClanName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ClanNotFoundException("Clan with name " + name + " was not found"));
    }

    @GetMapping("/tag/{tag}")
    public Clan getClanByTag(@PathVariable String tag) {
        return getClans()
                .stream()
                .filter(clan -> clan.getClanTag().equals(tag))
                .findFirst()
                .orElseThrow(() -> new ClanNotFoundException("Clan with tag " + tag + " was not found"));
    }


    @GetMapping("/member/{member}")
    public Clan getClanByMember(@PathVariable String member) {
        return getClans()
                .stream()
                .filter(clan -> clan.containsMember(member))
                .findFirst()
                .orElseThrow(() -> new ClanNotFoundException("Clan with member " + member + " was not found"));
    }

    @GetMapping("/all")
    public List<Clan> getClans() {
        return repository.findAll();
    }
}

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
@RequestMapping("/clans/clan")
public class ClanController {

    private final ClanRepository repository;

    public ClanController(ClanRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/delete/id/{id}")
    public Clan deleteClanById(@PathVariable String id) {
        return repository.deleteClanById(id);
    }

    @PostMapping("/delete/name/{name}")
    public Clan deleteClanByName(@PathVariable String name) {
        return repository.deleteClanByClanName(name);
    }

    @PostMapping("/delete/tag/{tag}")
    public Clan deleteClanByTag(@PathVariable String tag) {
        return repository.deleteClanByClanTag(tag);
    }

    @GetMapping("/get/id/{id}")
    public Clan getClanById(@PathVariable String id) {
        return repository.findClanById(id);
    }

    @GetMapping("/get/name/{name}")
    public Clan getClanByName(@PathVariable String name) {
        return repository.findClanByClanName(name);
    }

    @GetMapping("/get/tag/{tag}")
    public Clan getClanByTag(@PathVariable String tag) {
        return repository.findClanByClanTag(tag);
    }

    @GetMapping("/get/member/{member}")
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

package de.deroq.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Miles
 * @since 15.02.2023
 */
@Entity(name = "clans")
@Getter
public class Clan {

    @Id
    private String id;

    @Column(name = "clanname")
    private String clanName;

    @Column(name = "clantag")
    private String clanTag;

    private String members;

    public boolean containsMember(String uuid) {
        return getMembersAsMap().containsKey(uuid);
    }

    protected Map<String, String> getMembersAsMap() {
        return Arrays.stream(getMembers().split(";"))
                .map(s -> s.split("="))
                .collect(Collectors.toMap(s -> s[0], s -> s[1]));
    }
}

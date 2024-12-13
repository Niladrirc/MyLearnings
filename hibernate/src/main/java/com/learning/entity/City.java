package com.learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
@Entity(name = "cities")
public class City {
    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "city")
    private Set<Location> locations;
}

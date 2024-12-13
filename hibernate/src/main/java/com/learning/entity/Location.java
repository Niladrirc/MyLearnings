package com.learning.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "location")
public class Location {
    @Id
    private int pinCode;

    private String name;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "location")
    private List<Restaurant> restaurants;

}

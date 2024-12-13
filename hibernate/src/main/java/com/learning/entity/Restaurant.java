package com.learning.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "restaurant_name")
    private String name;

    private String address;

    @ManyToOne
    private Location location;

    @ManyToMany
    @JoinTable(
            name = "restaurant_dishes",
            joinColumns = @JoinColumn(name = "restaurants_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dishes_id", referencedColumnName = "id")
    )
    private List<Dish> availableDishes;
}

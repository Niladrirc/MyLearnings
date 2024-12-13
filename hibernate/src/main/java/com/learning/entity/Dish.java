package com.learning.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToMany
    @JoinTable(
            name = "restaurant_dishes",
            joinColumns = @JoinColumn(name = "dishes_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "restaurants_id", referencedColumnName = "id")
    )
    private List<Restaurant> restaurants;

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

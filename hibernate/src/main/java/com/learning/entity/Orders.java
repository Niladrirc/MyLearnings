package com.learning.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "order_total")
    private double orderTotal;

    @OneToMany
    private List<Dish> dishes;
}

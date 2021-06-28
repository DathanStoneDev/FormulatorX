package com.devstone.formulatorx.model;

import javax.persistence.*;


@Entity
public class ActiveIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private String active;

    @Column(name = "potency")
    private double potency;

}
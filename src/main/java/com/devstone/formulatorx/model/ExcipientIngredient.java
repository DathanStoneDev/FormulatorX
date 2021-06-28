package com.devstone.formulatorx.model;

import javax.persistence.*;

@Entity
public class ExcipientIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
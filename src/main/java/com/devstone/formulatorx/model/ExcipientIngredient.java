package com.devstone.formulatorx.model;

import javax.persistence.*;

@Entity
public class ExcipientIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public ExcipientIngredient() {

    }

    public ExcipientIngredient(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExcipientIngredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
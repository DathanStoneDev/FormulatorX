package com.devstone.formulatorx.model;

import javax.persistence.*;

@Entity
public class ExcipientIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="man_id")
    private Manufacturer manufacturer;

    public ExcipientIngredients() {

    }

    public ExcipientIngredients(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "ExcipientIngredients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer=" + manufacturer +
                '}';
    }
}

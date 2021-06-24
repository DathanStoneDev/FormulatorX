package com.devstone.formulatorx.model;

import javax.persistence.*;

@Entity
public class ActiveIngredients{
    //auto generated id in mySQL database
    @Id //need to make custom numbering starting with RM
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="active")
    private String active;

    @Column(name="potency")
    private double potency;

    /*each ingredient is a unique RM and can have one manufacturer
    if ingredient is deleted, we do not want to delete manufacturer*/
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="man_id")
    private Manufacturer manufacturer;

    public ActiveIngredients() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public double getPotency() {
        return potency;
    }

    public void setPotency(double potency) {
        this.potency = potency;
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
}

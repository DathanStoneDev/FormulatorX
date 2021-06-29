package com.devstone.formulatorx.model;


import javax.persistence.*;


@Entity
public class ActiveIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private String active;

    @Column(name = "potency")
    private double potency;

    public ActiveIngredient() {

    }

    public ActiveIngredient(Integer id, String name, String active, double potency) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.potency = potency;
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

    @Override
    public String toString() {
        return "ActiveIngredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active='" + active + '\'' +
                ", potency=" + potency +
                '}';
    }
}
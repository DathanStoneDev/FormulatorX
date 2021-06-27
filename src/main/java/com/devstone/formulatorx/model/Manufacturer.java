package com.devstone.formulatorx.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int manId;

    @Column(name="name")
    private String manName;

    @Column(name="country")
    private String country;

    @Column(name="city")
    private String city;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "manufacturer")
    private List<ActiveIngredient> activeIngredients;

    public Manufacturer() {

    }

    public Manufacturer(String manName, String country, String city, String email, String phone) {
        this.manName = manName;
        this.country = country;
        this.city = city;
        this.email = email;
        this.phone = phone;
    }


    public String getManName() {
        return manName;
    }
    public void setManName(String manName) {
        this.manName = manName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getManId() {
        return manId;
    }

    public void setManId(int manId) {
        this.manId = manId;
    }

    public List<ActiveIngredient> getActiveIngredients() {
        return activeIngredients;
    }

    public void setActiveIngredients(List<ActiveIngredient> activeIngredients) {
        this.activeIngredients = activeIngredients;
    }

    public void addIngredients(ActiveIngredient activeIngredient) {
        if(activeIngredients==null) {
            activeIngredients = new ArrayList<>();
        }
        activeIngredients.add(activeIngredient);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manId=" + manId +
                ", manName='" + manName + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", activeIngredients=" + activeIngredients +
                '}';
    }
}

package com.soloworld.blog.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Recipie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recipieId;
    private String name;
    private String description;
    private String imagePath;
    @OneToMany(mappedBy = "recipie")
    private Set<Ingredient> ingridients;

    public Set<Ingredient> getIngridients() {
        return ingridients;
    }

    public void setIngridients(Set<Ingredient> ingridients) {
        this.ingridients = ingridients;
    }

    public Integer getRecipieId() {
        return recipieId;
    }

    public void setRecipieId(Integer recipieId) {
        this.recipieId = recipieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}

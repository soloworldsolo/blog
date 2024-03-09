package com.soloworld.blog.entity;

import jakarta.persistence.*;

@Entity
public class Ingredient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer ingredientId;

    private String name;

    private Integer ammount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipie_id" ,nullable = false)
    private Recipie recipie;

    public Recipie getRecipie() {
        return recipie;
    }

    public void setRecipie(Recipie recipie) {
        this.recipie = recipie;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }
}

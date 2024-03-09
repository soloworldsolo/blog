package com.soloworld.blog.service;

import com.soloworld.blog.dto.Ingredient;
import com.soloworld.blog.dto.Recipie;
import com.soloworld.blog.repository.RecipieRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecipieServiceImpl implements IRecipieService{

    private final RecipieRepository recipieRepository;

    public RecipieServiceImpl(RecipieRepository recipieRepository) {
        this.recipieRepository = recipieRepository;
    }

    @Override
    public List<Recipie> getRecipies() {
        return mapToRecipie( recipieRepository.findAll());
    }

    private List<Recipie> mapToRecipie(List<com.soloworld.blog.entity.Recipie> recipieList) {
        if(CollectionUtils.isEmpty(recipieList)) {
            return Collections.emptyList();
        }

       return recipieList.stream().map(this::recipieConvertor).collect(Collectors.toList());
    }

    private List<Ingredient> mapToIngredients
            (Set<com.soloworld.blog.entity.Ingredient> ingridients) {
        if(CollectionUtils.isEmpty(ingridients)) {
            return Collections.emptyList();
        }
       return ingridients.stream().map(ingredient -> new Ingredient(ingredient.getIngredientId(),ingredient.getName(),ingredient.getAmmount())).collect(Collectors.toList());
    }

    private Recipie recipieConvertor(com.soloworld.blog.entity.Recipie recipie) {
        return new Recipie(recipie.getRecipieId(), recipie.getName(),recipie.getImagePath() ,recipie.getDescription(), 
                mapToIngredients(recipie.getIngridients()));
    }
}

package com.soloworld.blog.dto;

import java.util.List;

public record Recipie(Integer id,String name , String url , String description, List<Ingredient> ingredients) {
}

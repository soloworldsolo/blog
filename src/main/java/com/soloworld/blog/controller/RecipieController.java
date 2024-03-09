package com.soloworld.blog.controller;

import com.soloworld.blog.dto.Recipie;
import com.soloworld.blog.service.IRecipieService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
@CrossOrigin(origins = "*")
public class RecipieController {
    private IRecipieService recipieService;

    public RecipieController(IRecipieService recipieService) {
        this.recipieService = recipieService;
    }

    @GetMapping("/recipies")
    public List<Recipie> getRecipie() {
      return recipieService.getRecipies();
    }
}

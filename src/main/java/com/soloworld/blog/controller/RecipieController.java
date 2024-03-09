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


    @GetMapping("/recipies/ganesh")
    public String getRecipiega() {
        return

                """
                        [{"id":1,"name":"margarita pizza","url":"https://en.wikipedia.org/wiki/Pizza_Margherita#/media/File:Pizza_Margherita_stu_spivack.jpg","description":"izza Margherita is a typical Neapolitan pizza, made with tomatoes, mozzarella cheese, fresh basil, salt, and olive oil.","ingredients":[{"id":1,"name":"Marzano Tomatoes","ammount":5},{"id":2,"name":"Mozzarella Balls","ammount":3}]}]
                        """;
    }
}

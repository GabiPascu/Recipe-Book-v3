package com.gabi.challenge.controllers;

import com.gabi.challenge.models.Recipe;
import com.gabi.challenge.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

//    Recipe recipe1 = new Recipe("Eggs", "Bacon");
//    List<Recipe> recipeList = new ArrayList<>(List.of(recipe1, new Recipe("Omelette", "Egg")));


    @GetMapping("/recipes/add")
    public String showRecipeForm(Model model) {
        model.addAttribute("recipe", recipeService.createRecipe());

        return "recipeFormPage";
    }

    @PostMapping("/recipes/add")
    public String createRecipe(@ModelAttribute Recipe recipe) {
        recipeService.formatIngredients(recipe);

        recipeService.addRecipe(recipe);
//        if (recipeService.isValid(recipe)) {
//            recipeService.addRecipe(recipe);
//        } else {
//            System.out.println("Invalid input");
//        }

        return "redirect:/recipes";
    }

    @GetMapping("/recipes")
    public String showRecipeBook(Model model) {
        model.addAttribute("recipeListAttributeName", recipeService.getAllRecipes());

        return "recipeBook";
    }
}

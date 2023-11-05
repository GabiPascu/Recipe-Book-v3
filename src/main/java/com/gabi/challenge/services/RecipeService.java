package com.gabi.challenge.services;

import com.gabi.challenge.models.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getAllRecipes();

    Recipe createRecipe();

    void addRecipe(Recipe recipe);

    void formatIngredients(Recipe recipe);
}
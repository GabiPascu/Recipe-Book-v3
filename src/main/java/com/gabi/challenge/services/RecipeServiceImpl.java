package com.gabi.challenge.services;

import com.gabi.challenge.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private List<Recipe> recipeList = new ArrayList<>();

    @Override
    public List<Recipe> getAllRecipes() {

        return recipeList;
    }

    @Override
    public Recipe createRecipe() {

        return new Recipe();
    }

    @Override
    public void addRecipe(Recipe recipe) {
        recipeList.add(recipe);

    }

    @Override
    public void formatIngredients(Recipe recipe) {
        if (!recipe.getIngredient1().isEmpty()) {
            String[] strArr = recipe.getIngredient1().split(",");
            recipe.getIngredientsMap().put(strArr[0], Integer.valueOf(strArr[1]));
        }
        if (!recipe.getIngredient2().isEmpty()) {
            String[] strArr = recipe.getIngredient2().split(",");
            recipe.getIngredientsMap().put(strArr[0], Integer.valueOf(strArr[1]));
        }
        if (!recipe.getIngredient3().isEmpty()) {
            String[] strArr = recipe.getIngredient3().split(",");
            recipe.getIngredientsMap().put(strArr[0], Integer.valueOf(strArr[1]));
        }
    }
}
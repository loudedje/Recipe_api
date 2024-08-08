package recipe.recipe_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import recipe.recipe_app.model.RecipeApp;
import recipe.recipe_app.service.RecipeService;

@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    public RecipeService recipeService;


    @PostMapping
    public RecipeApp createRecipe(@RequestBody RecipeApp recipe){
        return recipeService.saveRecipe(recipe);
    }

}

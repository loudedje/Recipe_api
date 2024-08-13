package recipe.recipe_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import recipe.recipe_app.model.RecipeApp;
import recipe.recipe_app.repository.RecipeRepository;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;


    @Transactional
    public RecipeApp saveRecipe(RecipeApp recipe){

        return recipeRepository.save(recipe);
    }

}



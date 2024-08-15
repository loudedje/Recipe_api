package recipe.recipe_app.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import recipe.recipe_app.model.RecipeApp;
import recipe.recipe_app.repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;


    @Transactional
    public RecipeApp saveRecipe(RecipeApp recipe){
        return recipeRepository.save(recipe);
    }
    @Transactional
    public RecipeApp findRecipeById(long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe not found with id " + id));
    }


    public List<RecipeApp> findAll() {
        return recipeRepository.findAll();
    }

    public void deleteRecipe(long id) {
        recipeRepository.deleteById(id);
    }
}



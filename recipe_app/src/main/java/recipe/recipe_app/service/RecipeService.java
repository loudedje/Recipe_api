package recipe.recipe_app.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import recipe.recipe_app.model.RecipeApp;
import recipe.recipe_app.model.Ingredient;
import recipe.recipe_app.repository.RecipeRepository;
import recipe.recipe_app.repository.IngredientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Transactional
    public RecipeApp saveRecipe(RecipeApp recipe) {
        return recipeRepository.save(recipe);
    }

    @Transactional(readOnly = true)
    public RecipeApp findRecipeById(long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe not found with id " + id));
    }

    @Transactional(readOnly = true)
    public List<RecipeApp> findAll() {
        return recipeRepository.findAll();
    }

    @Transactional
    public void deleteRecipe(long id) {
        recipeRepository.deleteById(id);
    }

    @Transactional
    public void updateRecipe(RecipeApp updatedRecipe, Long id) {
        RecipeApp existingRecipe = recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe not found with id " + id));
        existingRecipe.setName(updatedRecipe.getName());
        existingRecipe.setDescription(updatedRecipe.getDescription());
        existingRecipe.setInstructions(updatedRecipe.getInstructions());
        existingRecipe.setPrepTime(updatedRecipe.getPrepTime());
        existingRecipe.setCookTime(updatedRecipe.getCookTime());
        existingRecipe.setServings(updatedRecipe.getServings());
        existingRecipe.setImageUrl(updatedRecipe.getImageUrl());
        recipeRepository.save(existingRecipe);
    }

    // Métodos relacionados a ingredientes

    @Transactional(readOnly = true)
    public Optional<Ingredient> findIngredientByNameQuantityAndUnit(String name, double quantity, String unit) {
        return ingredientRepository.findByNameAndQuantityAndUnit(name, quantity, unit);
    }

    @Transactional
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
}

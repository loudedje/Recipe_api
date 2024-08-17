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

    @Transactional
    public List<RecipeApp> findAll() {
        return recipeRepository.findAll();
    }

    @Transactional
    public void deleteRecipe(long id) {
        recipeRepository.deleteById(id);
    }

    @Transactional
    public void updateRecipe(RecipeApp updatedRecipe, Long id) {
        // Busca a receita existente no banco de dados
        RecipeApp existingRecipe = recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe not found with id " + id));
        // Atualiza os campos da receita existente com os valores do updatedRecipe
        existingRecipe.setName(updatedRecipe.getName());
        existingRecipe.setDescription(updatedRecipe.getDescription());
        existingRecipe.setInstructions(updatedRecipe.getInstructions());
        existingRecipe.setPrepTime(updatedRecipe.getPrepTime());
        existingRecipe.setCookTime(updatedRecipe.getCookTime());
        existingRecipe.setServings(updatedRecipe.getServings());
        existingRecipe.setImageUrl(updatedRecipe.getImageUrl());
    
        // Atualiza os ingredientes, se necessário
        if (updatedRecipe.getIngredients() != null) {
            existingRecipe.setIngredients(updatedRecipe.getIngredients());
            existingRecipe.getIngredients().forEach(ingredient -> {
                ingredient.setRecipe(existingRecipe); // Relaciona cada ingrediente à receita atualizada
            });
        }
        // Persiste a receita atualizada no banco de dados
        recipeRepository.save(existingRecipe);
    }
    

    
}



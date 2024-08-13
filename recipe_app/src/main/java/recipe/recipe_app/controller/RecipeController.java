package recipe.recipe_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipe.recipe_app.model.Ingredient;
import recipe.recipe_app.model.RecipeApp;
import recipe.recipe_app.repository.IngredientRepository;
import recipe.recipe_app.repository.RecipeRepository;
import recipe.recipe_app.service.RecipeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @PostMapping
    public ResponseEntity<RecipeApp> createRecipe(@RequestBody RecipeApp recipeApp) {
        List<Ingredient> persistedIngredients = recipeApp.getIngredients().stream()
                .map(ingredient -> {
                    Optional<Ingredient> existingIngredient = ingredientRepository.findByNameAndQuantityAndUnit(
                            ingredient.getName(), ingredient.getQuantity(), ingredient.getUnit());
                    return existingIngredient.orElseGet(() -> ingredientRepository.save(ingredient));
                })
                .collect(Collectors.toList());

        recipeApp.setIngredients(persistedIngredients);

        RecipeApp savedRecipe = recipeRepository.save(recipeApp);
        return ResponseEntity.ok(savedRecipe);
    }
}



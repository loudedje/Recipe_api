package recipe.recipe_app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipe.recipe_app.model.Ingredient;
import recipe.recipe_app.model.RecipeApp;
import recipe.recipe_app.service.RecipeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Operation(summary = "Create Recipe", description = "Create Recipe",
            tags = {"Recipe"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = RecipeApp.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @PostMapping
    public ResponseEntity<RecipeApp> createRecipe(@RequestBody RecipeApp recipeApp) {
        List<Ingredient> persistedIngredients = recipeApp.getIngredients().stream()
                .map(ingredient -> {
                    Optional<Ingredient> existingIngredient = recipeService.findIngredientByNameQuantityAndUnit(
                            ingredient.getName(),ingredient.getQuantity(),ingredient.getUnit());
                    return existingIngredient.orElseGet(() -> recipeService.saveIngredient(ingredient));
                })
                .collect(Collectors.toList());

        recipeApp.setIngredients(persistedIngredients);

        RecipeApp savedRecipe = recipeService.saveRecipe(recipeApp);
        return ResponseEntity.ok(savedRecipe);
    }

    @Operation(summary = "Finds Recipe", description = "Finds a recipe by ID",
            tags = {"Recipe"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = RecipeApp.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )

    @GetMapping("/{id}")
    public ResponseEntity<RecipeApp> getRecipeById(@PathVariable long id) {
        RecipeApp recipeApp = recipeService.findRecipeById(id);
        return ResponseEntity.ok(recipeApp);
    }

    @Operation(summary = "Finds all recipes", description = "Finds all recipes",
            tags = {"Recipe"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = RecipeApp.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @GetMapping
    public ResponseEntity<List<RecipeApp>> getAllRecipes() {
        List<RecipeApp> recipeApps = recipeService.findAll();
        return ResponseEntity.ok(recipeApps);
    }

    @Operation(summary = "Deletes Recipe", description = "Deletes a recipe by ID",
            tags = {"Recipe"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }
}

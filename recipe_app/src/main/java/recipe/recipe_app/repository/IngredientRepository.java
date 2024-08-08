package recipe.recipe_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import recipe.recipe_app.model.Ingredient;

public interface IngredientRepository extends JpaRepository< Ingredient, Long> {
}

package recipe.recipe_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import recipe.recipe_app.model.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByNameAndQuantityAndUnit(String name, String quantity, String unit);
}

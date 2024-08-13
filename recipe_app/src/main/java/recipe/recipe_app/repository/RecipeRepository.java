package recipe.recipe_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import recipe.recipe_app.model.RecipeApp;

public interface RecipeRepository extends JpaRepository<RecipeApp, Long> {

}


package recipe.recipe_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import recipe.recipe_app.model.Category;

public interface CategoryRepository extends JpaRepository <Category,Long> {

}

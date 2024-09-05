package recipe.recipe_app.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class RecipeException extends DataIntegrityViolationException {
    public RecipeException(String message) {
        super(message);
    }
}

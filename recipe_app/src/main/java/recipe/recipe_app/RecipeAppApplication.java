package recipe.recipe_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "recipe.recipe_app.model")
public class RecipeAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(RecipeAppApplication.class, args);
	}
}

package recipe.recipe_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "recipe.recipe_app.model")
@ComponentScan(basePackages = "recipe.recipe_app.controller")
@ComponentScan(basePackages = "recipe.recipe_app")

public class RecipeAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(RecipeAppApplication.class, args);
	}
}


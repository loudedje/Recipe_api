package recipe.recipe_app.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

import jakarta.validation.constraints.Positive;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name="RECIPE")

public class RecipeApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String instructions;
    @Positive(message = "Preparation time must be a positive number")
    private int prepTime;
    @Positive(message = "Cooking time must be a positive number")
    private int cookTime;
    @Positive(message = "Servings must be a positive number")
    private int servings;
    @URL(message = "Image URL must be a valid URL")
    private String imageUrl;
    private String category;


    @ManyToMany
    private List<Ingredient> ingredients;

    @ElementCollection
    private List<String> tags;

    public RecipeApp() {

    }
    public RecipeApp(Long id, String name, String description, String instructions, int prepTime, int cookTime, int servings, String imageUrl, String category, List<Ingredient> ingredients, List<String> tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.imageUrl = imageUrl;
        this.category = category;
        this.ingredients = ingredients;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeApp recipeApp = (RecipeApp) o;
        return prepTime == recipeApp.prepTime && cookTime == recipeApp.cookTime && servings == recipeApp.servings && Objects.equals(id, recipeApp.id) && Objects.equals(name, recipeApp.name) && Objects.equals(description, recipeApp.description) && Objects.equals(instructions, recipeApp.instructions) && Objects.equals(imageUrl, recipeApp.imageUrl) && Objects.equals(category, recipeApp.category) && Objects.equals(ingredients, recipeApp.ingredients) && Objects.equals(tags, recipeApp.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, instructions, prepTime, cookTime, servings, imageUrl, category, ingredients, tags);
    }
}


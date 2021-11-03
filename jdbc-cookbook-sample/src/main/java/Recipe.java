public class Recipe {
    private int id;
    private final String title;
    private final int prepTime;
    private final String ingredients;
    private final String description;

    public Recipe(String title, int prepTime, String ingredients, String description) {
        this.title = title;
        this.prepTime = prepTime;
        this.ingredients = ingredients;
        this.description = description;
    }

    public Recipe(Integer id, String title, int prepTime, String ingredients, String description) {
        this(title, prepTime, ingredients, description);
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return title +
                ",\n - składniki: " + ingredients +
                ",\n - czas przygotowania: " + prepTime + "(min)" +
                ",\n - sposób przygotowania: " + description;
    }

    public void setId(int anInt) {
        this.id=anInt;
    }
}

import java.sql.*;
import java.util.Optional;

public class RecipeDao {
    private static final String URL = "jdbc:mysql://localhost:3306/cookbook";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private Connection connection;

    public RecipeDao() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    void save(Recipe recipe) {
        final String insertQuery = String.format("insert into cookbook.recipe (title, preptime, ingredients, description) " +
                        "values('%s','%d','%s','%s')", recipe.getTitle(), recipe.getPrepTime(),
                recipe.getIngredients(), recipe.getDescription());
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                recipe.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Optional<Recipe> findByTitle(String recipeTitle) {
        final String searchQuery =
                "select id,title,preptime,ingredients,description from cookbook.recipe where title ='" + recipeTitle + "'";
        try (Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(searchQuery);
            if (set.next()) {
                int id = set.getInt("id");
                String title = set.getString("title");
                int prepTime = set.getInt("preptime");
                String ingredients = set.getString("ingredients");
                String desc = set.getString("description");
                return Optional.of(new Recipe(id, title, prepTime, ingredients, desc));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    boolean deleteById(int id) {
        final String deleteQuery = "delete from cookbook.recipe where id = " + id;
        try (Statement statement = connection.createStatement()) {
            int i = statement.executeUpdate(deleteQuery);
            return i != 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    boolean update(Recipe recipe) {
        final String updateQuery = String.format("update recipe set title='%s',description='%s',ingredients='%s',preptime='%d' where id = '%d'",
                recipe.getTitle(), recipe.getDescription(), recipe.getIngredients(), recipe.getPrepTime(), recipe.getId());
        try (Statement statement = connection.createStatement()) {
            int i = statement.executeUpdate(updateQuery);
            return i != 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

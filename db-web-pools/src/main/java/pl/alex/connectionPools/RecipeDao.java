package pl.alex.connectionPools;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecipeDao {
    private final DataSource dataSource;

    public RecipeDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    List<Recipe> findAll() {
        final String findQuery = "SELECT id, title, description, ingredients, preptime FROM recipe";
        List<Recipe> recipes = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("description");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                int prepTime = resultSet.getInt("preptime");
                recipes.add(new Recipe(id, title, description, ingredients, prepTime));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recipes;
    }
}

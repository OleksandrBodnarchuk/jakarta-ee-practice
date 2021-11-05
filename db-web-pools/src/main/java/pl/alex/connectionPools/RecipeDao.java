package pl.alex.connectionPools;

import javax.naming.NamingException;
import javax.sql.DataSource;

public class RecipeDao {
    private final DataSource dataSource;

    public RecipeDao() {
        try{
            this.dataSource = DataSourceProvider.getDataSource();
        }catch (NamingException e){
            throw new RuntimeException(e);
        }
    }
}

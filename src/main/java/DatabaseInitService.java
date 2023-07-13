import db.Database;
import org.flywaydb.core.Flyway;
import org.h2.jdbcx.JdbcDataSource;

public class DatabaseInitService {

    public void init() {
        Database database = Database.getInstance();

        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(database.getUrl());
        dataSource.setUser(database.getLogin());
        dataSource.setPassword(database.getPassword());

        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .load();

        flyway.migrate();
    }

}

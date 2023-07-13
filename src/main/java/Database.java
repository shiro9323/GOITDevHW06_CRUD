import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Database {
    private static Database DATABASE = new Database();
    private String url;
    private String login;
    private String password;
    private Connection connection;

    private Database() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("settings.properties"));
            this.url = props.getProperty("database_url");
            this.login = props.getProperty("database_login");
            this.password = props.getProperty("database_pass");
            this.connection = DriverManager.getConnection(url, login, password);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (DATABASE == null) {
            DATABASE = new Database();
        }
        return DATABASE;
    }

    public Connection getConnection() {
        return connection;
    }
}

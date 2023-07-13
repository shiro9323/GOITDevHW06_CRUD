package crud;





import db.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private final Connection connection;

    public ClientService() {
        connection = Database.getConnection();
    }

    public Long create(String name) {

        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO client (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                return generatedKeys.next() ? generatedKeys.getLong(1) : null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getById(long id) {

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name FROM client WHERE id = ?")) {
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next() ? resultSet.getString("name") : null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setName(Long id, String name) {

        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE client SET name = ? WHERE id = ?")) {
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(long id) {

        try (PreparedStatement projectWorkerStatement = connection.prepareStatement("DELETE FROM project_worker WHERE project_id IN (SELECT id FROM project WHERE client_id = ?)");
             PreparedStatement projectStatement = connection.prepareStatement("DELETE FROM project WHERE client_id = ?");
             PreparedStatement clientStatement = connection.prepareStatement("DELETE FROM client WHERE id = ?")) {

            projectWorkerStatement.setLong(1, id);
            projectWorkerStatement.execute();

            projectStatement.setLong(1, id);
            projectStatement.execute();

            clientStatement.setLong(1, id);
            clientStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Client> listAll() {
        String select = "SELECT id, name FROM client ORDER BY id";
        List<Client> clients = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    clients.add(new Client(resultSet.getLong("id"), resultSet.getString("name")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clients;
    }


}

import crud.ClientService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseInitService databaseInitService = new DatabaseInitService();
        databaseInitService.init();

        ClientService clientService = new ClientService();
        System.out.println("clientService.create(\"testCRUD1\") = " + clientService.create("testCRUD1"));
        System.out.println("clientService.listAll() = " + clientService.listAll());
        System.out.println("clientService.getById(6l) = " + clientService.getById(6l));
        clientService.setName(6l, "testSetName1");
        System.out.println("clientService.listAll() = " + clientService.listAll());
        clientService.deleteById(5l);
        System.out.println("clientService.listAll() = " + clientService.listAll());
    }
}

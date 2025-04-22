package SOLID.D;

public class DatabaseService implements Service {
    public void save(String data) {
        System.out.println("Saving data to database: " + data);
    }



}
/*
class DatabaseService {
    public void save(String data) {
        System.out.println("Saving data to database: " + data);
    }
}

class UserService {
    private DatabaseService databaseService;

    public UserService() {
        this.databaseService = new DatabaseService();
    }

    public void saveUser(String user) {
        databaseService.save(user);
    }
}

 */

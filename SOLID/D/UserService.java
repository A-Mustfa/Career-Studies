package SOLID.D;

public class UserService implements Service{
    Service service;

    public UserService(Service service) {
        this.service = service;
    }

    public void save(String data) {
        service.save(data);
    }
}

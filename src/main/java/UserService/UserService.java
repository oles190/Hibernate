package UserService;

import model.User;

import java.util.List;

public interface UserService {



    void create(User user);
    void deleteById( int id);
    void update(User user);
    User findById(int id);
    List<User> findAll();


}

package UserService.impl;

import UserService.UserService;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.MySessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {

    Session session;
    Transaction transaction;

    @Override
    public void create(User user) {
        initialize();
        session.persist(user);
        transaction.commit();
        session.close();

    }

    @Override
    public void deleteById(int id) {
        User user =findById(id);
        initialize();
        session.delete(user);
        transaction.commit();
        session.close();


    }

    @Override
    public void update(User user) {
        User userToUpdate= findById(user.getId());
      userToUpdate.setAge(user.getAge());
        userToUpdate.setName(user.getName());
        initialize();
        session.update(userToUpdate);
        transaction.commit();
        session.close();




    }

    @Override
    public User findById(int id) {
        initialize();
      User user=  session.get(User.class,id);
        session.close();

        return user;
    }

    @Override
    public List<User> findAll() {
        initialize();
        List<User> users= session.createCriteria(User.class).list();
        session.close();
        return users;
    }


    private void initialize(){
         session= MySessionFactory.getSession();
         transaction=session.beginTransaction();
    }
}

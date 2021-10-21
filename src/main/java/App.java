import UserService.UserService;
import UserService.impl.UserServiceImpl;
import model.CarPassport;
import model.Product;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.MySessionFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {


    private static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {


        User user1 = new User(1, "Oleg", 34);
        User user2 = new User(2, "Tom", 24);


        CarPassport carPassport1 = new CarPassport(1, "BMW", 2020,user1);
        CarPassport carPassport2 = new CarPassport(2, "Audi", 2021,user1);
        CarPassport carPassport3 = new CarPassport(3, "Mercedes", 2028,user1);
        CarPassport carPassport4 = new CarPassport(4, "Nissan", 2038,user2);
        CarPassport carPassport5 = new CarPassport(5, "Kia", 2018,user2);


        Product product1 = new Product(1, "Cola", 14);
        Product product2 = new Product(2, "Banana", 24);
        Product product3 = new Product(3, "Milk", 44);
    //   userService.create(user1);

        Session session = MySessionFactory.getSession();
        Transaction transaction = session.beginTransaction();


user2.setCars(new HashSet<>(Arrays.asList(carPassport4,carPassport5)));
user2.setProducts(new HashSet<>(Arrays.asList(product3)));


user1.setCars(new HashSet<>(Arrays.asList(carPassport1,carPassport2)));
user1.addCar(carPassport3);
user1.setProducts(new HashSet<>(Arrays.asList(product1,product2)));
session.update(user1);
session.persist(user2);
transaction.commit();
session.close();

        System.out.println(user1.getCars());

    }
}

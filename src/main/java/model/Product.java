package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {


    @Id
    @Column (name="product_id")
    private int id;
    @Column (name="name")
    private String name;
    @Column (name="price")
    private int price;
    @ManyToMany(mappedBy = "products")
   private Set<User> users;


    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public void addUser( User user){
        users.add(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && price == product.price && Objects.equals(name, product.name) && Objects.equals(users, product.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, users);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

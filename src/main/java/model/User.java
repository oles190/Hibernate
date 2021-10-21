package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name = "user_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CarPassport> cars;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_product", joinColumns =
    @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;

    }


    public void addCar(CarPassport car) {
        cars.add(car);
    }

    public void addProduct(Product product) {
        products.add(product);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}



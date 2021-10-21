package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;


@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cars")

public class CarPassport {

    @Id
    @Column(name="car_id")
    private int id;
    @Column(name="model")
    private String model;
    @Column(name="year")
    private int year;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_user_id")
    private User user;



    public CarPassport(int id, String model, int year,User user) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.user=user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPassport that = (CarPassport) o;
        return id == that.id && year == that.year && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, year);
    }

    @Override
    public String toString() {
        return "CarPassport{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}

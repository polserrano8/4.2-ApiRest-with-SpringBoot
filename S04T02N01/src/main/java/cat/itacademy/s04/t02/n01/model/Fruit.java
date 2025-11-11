package cat.itacademy.s04.t02.n01.model;
import jakarta.persistence.*;


import java.io.Serializable;



@Entity
@Table(name="fruit")
public class Fruit implements Serializable{
    public Fruit() {}
    public Fruit(String name, Integer quantityKg) {
        this.name = name;
        this.quantityKilos = quantityKg;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",length = 50,nullable = false,unique=true)
    private String name;
    @Column(name = "quantity-kilos",length =100)
    int quantityKilos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityKg() {
        return quantityKilos;
    }

    public void setQuantityKg(int quantityKilos) {
        this.quantityKilos = quantityKilos;
    }
}

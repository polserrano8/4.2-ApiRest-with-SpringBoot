package cat.itacademy.s04.t02.n01.services;

import cat.itacademy.s04.t02.n01.model.Fruit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface FruitService {
    Iterable<Fruit>findAll();
    Optional<Fruit> findById(long id);
    Optional<Fruit>findByName(String name);
    Fruit addFruit(Fruit fruit);
    void updateFruitbyId(long id ,Fruit updatedFruit);
    void updateFruitbyName(String name, Fruit updatedFruit);
    Page<Fruit> findAll(Pageable pageable);
    void deleteById(long id);
    void deleteByName(String name);
    Optional<Fruit> getOne(long id);

}

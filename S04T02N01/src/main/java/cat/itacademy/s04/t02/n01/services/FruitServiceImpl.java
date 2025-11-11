package cat.itacademy.s04.t02.n01.services;

import cat.itacademy.s04.t02.n01.exceptions.FruitExistsException;
import cat.itacademy.s04.t02.n01.exceptions.FruitNotExistsException;
import cat.itacademy.s04.t02.n01.model.Fruit;
import cat.itacademy.s04.t02.n01.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{
    @Autowired
    private FruitRepository fruitRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Fruit> findById(long id) {
        return fruitRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Fruit> findByName(String name) {
        return fruitRepository.findByName(name);
    }

    @Override
    @Transactional
    public Fruit addFruit(Fruit fruit) {

        if(fruitRepository.findByName(fruit.getName()).isPresent()){
            throw new FruitExistsException("The fruit with the following name already exists: "+ fruit.getId()+"\n");
        }
        return fruitRepository.save(fruit);
    }

    @Override
    @Transactional
    public void updateFruitbyId(long id, Fruit updatedFruit) {
        Optional<Fruit> existingFruit = fruitRepository.findById(id);
        if (existingFruit.isPresent()) {
            Fruit fruit = existingFruit.get();
            fruit.setName(updatedFruit.getName());
            fruit.setQuantityKg(updatedFruit.getQuantityKg());
            fruitRepository.save(fruit);
        }else{throw new FruitNotExistsException("Fruit not found with id:"+id);}
    }
;
    @Override
    @Transactional
    public void updateFruitbyName(String name, Fruit updatedFruit) {
        Optional<Fruit> existingFruit = fruitRepository.findByName(name);
        if(!existingFruit.isPresent()){
            throw new FruitNotExistsException("Fruit not found with name:"+name);
        }
        else if (existingFruit.isPresent()) {
            Fruit fruit = existingFruit.get();
            fruit.setQuantityKg(updatedFruit.getQuantityKg());

            fruitRepository.save(fruit);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Page<Fruit> findAll(Pageable pageable) {
        return fruitRepository.findAll(pageable);
    }

    @Override
    public void deleteById(long id) {
        fruitRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        fruitRepository.deleteByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Fruit> getOne(long id) {
        return fruitRepository.getOne(id);
    }

}

package cat.itacademy.s04.t02.n02.controllers;


import cat.itacademy.s04.t02.n02.model.Fruit;
import cat.itacademy.s04.t02.n02.services.FruitService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/fruits")
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @PostMapping
    public ResponseEntity<?> createFruit(@RequestBody Fruit fruit){
        return ResponseEntity.status(HttpStatus.CREATED).body(fruitService.addFruit(fruit));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> readFruit(@PathVariable(value="id") long fruitId){
        Optional<Fruit> oFruit = fruitService.findById(fruitId);
        if(!oFruit.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oFruit);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Fruit> updateByID(@RequestBody Fruit nFruitDetails,@PathVariable(value ="id") Long fruitId){
        Optional<Fruit> fruit = fruitService.findById(fruitId);
        // Para copiar el id en el objeto pasado. BeanUtils.copyProperties(nFruitDetails,fruit.get());
        if(!fruit.isPresent()){
            return ResponseEntity.notFound().build();
        }
        fruit.get().setName(nFruitDetails.getName());
        fruit.get().setQuantityKg(nFruitDetails.getQuantityKg());
        return ResponseEntity.status(HttpStatus.CREATED).body(fruitService.addFruit(fruit.get()));
    }
    @PutMapping("/{name}")
    public ResponseEntity<Fruit> updateByName(@RequestBody Fruit nFruitDetails,@PathVariable(value ="name") String fruitName){
        Optional<Fruit> fruit = fruitService.findByName(fruitName);
        // Para copiar el id en el objeto pasado. BeanUtils.copyProperties(nFruitDetails,fruit.get());
        if(!fruit.isPresent()){
            return ResponseEntity.notFound().build();
        }
        fruit.get().setName(nFruitDetails.getName());
        fruit.get().setQuantityKg(nFruitDetails.getQuantityKg());
        return ResponseEntity.status(HttpStatus.CREATED).body(fruitService.addFruit(fruit.get()));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteById(@PathVariable(value="id") Long fruitId){
        if(!fruitService.findById(fruitId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        fruitService.deleteById(fruitId);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{name}")
    public ResponseEntity<?>deleteByName(@PathVariable(value="name") String fruitName){
        if(!fruitService.findByName(fruitName).isPresent()){
            return ResponseEntity.notFound().build();
        }
        fruitService.deleteByName(fruitName);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{all}")
    public List<Fruit> readAll(){
        List<Fruit> fruits = StreamSupport
                .stream(fruitService.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return fruits;
    }
}

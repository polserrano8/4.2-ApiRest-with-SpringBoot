package cat.itacademy.s04.t02.n01.exceptions;

public class FruitExistsException extends RuntimeException {
    public FruitExistsException(String message){
        super(message);
    }
}

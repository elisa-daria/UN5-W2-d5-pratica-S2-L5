package elisadaria.UN5W2d5praticaS2L5.exceptions;

public class NotFoundEx extends RuntimeException{
    public NotFoundEx(String msg){
        super(msg);
    }
    public NotFoundEx(long id){
        super(id+" not found!");
    }
}

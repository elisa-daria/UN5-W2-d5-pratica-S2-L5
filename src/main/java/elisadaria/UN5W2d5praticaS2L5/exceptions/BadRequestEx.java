package elisadaria.UN5W2d5praticaS2L5.exceptions;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;
@Getter
public class BadRequestEx extends RuntimeException{
    private List<ObjectError>errors;
    public BadRequestEx(String message) {
        super(message);
    }
    public BadRequestEx(List<ObjectError>errors){
        super("ERRORI NEL PAYLOAD");
        this.errors=errors;
    }
}

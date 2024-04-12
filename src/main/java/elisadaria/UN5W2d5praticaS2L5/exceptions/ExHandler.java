package elisadaria.UN5W2d5praticaS2L5.exceptions;

import elisadaria.UN5W2d5praticaS2L5.payloads.ErrorsPayloadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExHandler {
    @ExceptionHandler(NotFoundEx.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayloadDTO handle404(NotFoundEx ex){
        return new ErrorsPayloadDTO(ex.getMessage(), LocalDateTime.now());
    }

}

package elisadaria.UN5W2d5praticaS2L5.exceptions;

import elisadaria.UN5W2d5praticaS2L5.payloads.ErrorsPayloadDTO;
import elisadaria.UN5W2d5praticaS2L5.payloads.ListofErrorsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExHandler {
    @ExceptionHandler(NotFoundEx.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayloadDTO handle404(NotFoundEx ex) {
        return new ErrorsPayloadDTO(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(BadRequestEx.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ListofErrorsDTO handleB_R(BadRequestEx ex) {
        List<String> errorsMsgs = new ArrayList<>();
        if (ex.getErrors() != null)
            errorsMsgs = ex.getErrors().stream().map((error -> error.getDefaultMessage())).toList();
        return new ListofErrorsDTO(ex.getMessage(), LocalDateTime.now(), errorsMsgs);

    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsPayloadDTO handle500(Exception ex){
        ex.printStackTrace();
        return new ErrorsPayloadDTO("ERRORE LATO SERVER-working on it",LocalDateTime.now());
    }

}

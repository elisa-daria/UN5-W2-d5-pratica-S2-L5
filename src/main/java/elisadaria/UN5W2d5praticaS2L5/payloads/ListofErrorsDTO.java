package elisadaria.UN5W2d5praticaS2L5.payloads;

import java.time.LocalDateTime;
import java.util.List;

public record ListofErrorsDTO(String msg, LocalDateTime timeStamp, List<String>errors) {
}

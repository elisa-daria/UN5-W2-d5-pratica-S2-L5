package elisadaria.UN5W2d5praticaS2L5.payloads;

import java.time.LocalDateTime;

public record ErrorsPayloadDTO(String msg, LocalDateTime timeStamp) {
    public ErrorsPayloadDTO(String msg, LocalDateTime timeStamp) {
        this.msg = msg;
        this.timeStamp = timeStamp;
    }
}

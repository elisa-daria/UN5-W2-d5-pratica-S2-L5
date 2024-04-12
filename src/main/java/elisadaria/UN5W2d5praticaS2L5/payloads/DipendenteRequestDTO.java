package elisadaria.UN5W2d5praticaS2L5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record DipendenteRequestDTO(
        @NotEmpty(message = "lo username è d'obbligo!!")
        @Size(max = 20,message = "non esageriamo: troppo lungo!MAX:20caratteri")
        String username,
        @NotEmpty(message = "il nome è un campo obbligatorio")
        @Size(max = 30, message = "massimo caratteri:30")
        String name,
        @NotEmpty(message = "il cognome è un campo obbligatorio")
        @Size(max = 30, message = "massimo caratteri:30")
        String surname,
        @NotEmpty(message = "email obbligatoria")
        @Email(message = "email non valida")
        String email) {
}

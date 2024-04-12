package elisadaria.UN5W2d5praticaS2L5.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="dipendenti")
@Data
public class Dipendente {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private long id;
    private String username;
    private String name;
    private String surname;
    private String email;
    @OneToMany(mappedBy="dipendente")
    @JsonIgnore
    private List<Dispositivo> dispositivi;

}

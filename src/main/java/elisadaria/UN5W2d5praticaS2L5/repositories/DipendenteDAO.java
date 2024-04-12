package elisadaria.UN5W2d5praticaS2L5.repositories;

import elisadaria.UN5W2d5praticaS2L5.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DipendenteDAO extends JpaRepository<Dipendente,Long> {
    Optional<Dipendente> findByEmail(String email);
}

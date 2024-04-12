package elisadaria.UN5W2d5praticaS2L5.services;

import elisadaria.UN5W2d5praticaS2L5.config.CloudinaryConfig;
import elisadaria.UN5W2d5praticaS2L5.entities.Dipendente;
import elisadaria.UN5W2d5praticaS2L5.exceptions.NotFoundEx;
import elisadaria.UN5W2d5praticaS2L5.repositories.DipendenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DipendentiService {
    @Autowired
    private DipendenteDAO dipendenteDAO;
    @Autowired
   private CloudinaryConfig cloudinaryUp;

    //GENERIC GET
    public Page<Dipendente> getDipendenti(int page, int size, String sortBy){
        if(size>25)size=25;
        Pageable pageable= PageRequest.of(page,size, Sort.by(sortBy));
        return this.dipendenteDAO.findAll(pageable);
    }

    //GET BY ID
    public Dipendente findById(long id){
        return this.dipendenteDAO.findById(id).orElseThrow(()->new NotFoundEx(id));
    }

    //SAVE


}

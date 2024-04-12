package elisadaria.UN5W2d5praticaS2L5.controllers;


import elisadaria.UN5W2d5praticaS2L5.entities.Dipendente;
import elisadaria.UN5W2d5praticaS2L5.exceptions.BadRequestEx;
import elisadaria.UN5W2d5praticaS2L5.payloads.DipendenteRequestDTO;
import elisadaria.UN5W2d5praticaS2L5.payloads.DipendenteRespDTO;
import elisadaria.UN5W2d5praticaS2L5.services.DipendentiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {
    @Autowired
    DipendentiService dipendentiService;

    //http://localhost:3002/dipendenti
    @GetMapping("")
    public Page<Dipendente> getDipendenti(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "username") String sortBy
    ) {
        return dipendentiService.getDipendenti(page, size, sortBy);
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public DipendenteRespDTO savingD(@RequestBody @Validated DipendenteRequestDTO payload, BindingResult validation)throws Exception{
        if(validation.hasErrors()){
            throw new BadRequestEx(validation.getAllErrors());
        }
        Dipendente newD=dipendentiService.save(payload);
        return new DipendenteRespDTO(newD.getId());
    }
    //http://localhost:3002/dipendenti/{id}
    @GetMapping("/{id}")
    public Dipendente findById(@PathVariable long id) {
        return dipendentiService.findById(id);
    }
    @PutMapping("/{id}")
    public Dipendente updating(@PathVariable long id,@RequestBody Dipendente payload){
        return dipendentiService.update(id,payload);
    }
    @PutMapping("/{id}/pic")
    public Dipendente picUp(@RequestParam("pic")MultipartFile img, @PathVariable long id){
        try{
            return dipendentiService.uploadPic(id,img);
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleting(@PathVariable long id){
        dipendentiService.delete(id);
    }
}

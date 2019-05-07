package controller;

import domain.Carte;
import service.CartiService;
import validator.CarteValidator;

import java.util.List;

public class BibliotecaCtrl {
    private final CartiService service;

    public BibliotecaCtrl(CartiService service) {
        this.service = service;
    }

    public void adaugaCarte(Carte c) throws Exception{
        CarteValidator.validateCarte(c);
        service.adaugaCarte(c);
    }

    public List<Carte> cautaCarte(String autor) throws Exception{
        CarteValidator.isStringOK(autor);
        return service.cautaCarte(autor);
    }

    public List<Carte> getCarti() throws Exception{
        return service.getCarti();
    }

    public List<Carte> getCartiOrdonateDinAnul(String an) throws Exception{
        if(!CarteValidator.isNumber(an))
            throw new Exception("Nu e numar!");
        return service.getCartiOrdonateDinAnul(an);
    }

}

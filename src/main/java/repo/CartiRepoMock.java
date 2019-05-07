package repo;

import domain.Carte;
import utils.CartiUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CartiRepoMock implements CartiRepoInterface {
    private List<Carte> carti;

    public CartiRepoMock(){
        carti = new ArrayList<Carte>();

        carti.add(CartiUtils.getCarteFromString("Povesti;Mihai Eminescu,Ion Caragiale,Ion Creanga;1973;Corint;povesti,povestiri"));
        carti.add(CartiUtils.getCarteFromString("Poezii;Sadoveanu;1973;Corint;poezii"));
        carti.add(CartiUtils.getCarteFromString("Enigma Otiliei;George Calinescu;1948;Litera;enigma,otilia"));
        carti.add(CartiUtils.getCarteFromString("Dale carnavalului;Caragiale Ion;1948;Litera;caragiale,carnaval"));
        carti.add(CartiUtils.getCarteFromString("Intampinarea crailor;Mateiu Caragiale;1948;Litera;mateiu,crailor"));
        carti.add(CartiUtils.getCarteFromString("Test;Calinescu,Tetica;1992;Pipa;am,casa"));

    }

    @Override
    public void adaugaCarte(Carte c) {
        carti.add(c);
    }


    @Override
    public List<Carte> getCarti() {
        return carti;
    }

    @Override
    public void modificaCarte(Carte nou, Carte vechi) {
        // TODO Auto-generated method stub

    }

    @Override
    public void stergeCarte(Carte c) {
        // TODO Auto-generated method stub

    }
}

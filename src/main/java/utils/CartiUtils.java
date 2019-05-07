package utils;

import domain.Carte;

import java.util.Arrays;

public class CartiUtils {
    public static Carte getCarteFromString(String carte){
        Carte c = new Carte();
        String []atr = carte.split(";");
        String []referenti = atr[1].split(",");
        String []cuvCheie = atr[4].split(",");

        c.setTitlu(atr[0]);
        c.setReferenti(Arrays.asList(referenti));
        c.setAnAparitie(atr[2]);
        c.setCuvinteCheie(Arrays.asList(cuvCheie));

        return c;
    }
}

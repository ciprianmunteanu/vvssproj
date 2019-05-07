package repo;

import domain.Carte;

import java.util.List;

public interface CartiRepoInterface {
    void adaugaCarte(Carte c);
    void modificaCarte(Carte nou, Carte vechi);
    void stergeCarte(Carte c);
    List<Carte> getCarti();
}

package service;

import domain.Carte;
import repo.CartiRepoInterface;

import java.util.*;

public class CartiService {
    private final CartiRepoInterface repo;

    public CartiService(CartiRepoInterface repo) {
        this.repo = repo;
    }

    public List<Carte> cautaCarte(String ref) {
        List<Carte> carti = repo.getCarti();
        List<Carte> cartiGasite = new ArrayList<Carte>();
        int i=0;
        while (i<carti.size()){
            boolean flag = false;
            List<String> lref = carti.get(i).getReferenti();
            int j = 0;
            while(j<lref.size()){
                if(lref.get(j).toLowerCase().contains(ref.toLowerCase())){
                    flag = true;
                    break;
                }
                j++;
            }
            if(flag == true){
                cartiGasite.add(carti.get(i));
            }
            i++;
        }
        return cartiGasite;
    }

    public List<Carte> getCartiOrdonateDinAnul(String an) {
        List<Carte> lc = repo.getCarti();
        List<Carte> lca = new ArrayList<Carte>();
        for(Carte c:lc){
            if(c.getAnAparitie().equals(an)){
                lca.add(c);
            }
        }

        Collections.sort(lca,new Comparator<Carte>(){

            @Override
            public int compare(Carte a, Carte b) {
                if(a.getAnAparitie().compareTo(b.getAnAparitie())==0){
                    return a.getTitlu().compareTo(b.getTitlu());
                }

                return a.getTitlu().compareTo(b.getTitlu());
            }

        });

        return lca;
    }

    public boolean cautaDupaCuvinteCheie(Carte carte, List<String> cuvinte){
        for(String c:carte.getCuvinteCheie()){
            for(String cuv:cuvinte){
                if(c.equals(cuv))
                    return true;
            }
        }
        return false;
    }

    public boolean cautaDupaAutor(Carte carte, String autor){
        for(String a:carte.getReferenti()){
            if(a.contains(autor))
                return true;
        }
        return false;
    }

    public void adaugaCarte(Carte c) {
        repo.adaugaCarte(c);
    }

    public List<Carte> getCarti() {
        return repo.getCarti();
    }
}

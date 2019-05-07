import controller.BibliotecaCtrl;
import domain.Carte;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import repo.CartiRepoMock;
import service.CartiService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F1Tests {
    private static BibliotecaCtrl ctrl;
    private Carte c;

    @BeforeClass
    public static void setup() {
        CartiRepoMock cartiRepoMock = new CartiRepoMock();
        CartiService cartiService = new CartiService(cartiRepoMock);
        ctrl = new BibliotecaCtrl(cartiService);
    }

    @Before
    public void perTestSetup() {
        c = new Carte();
        c.setTitlu("abc");
        c.setReferenti(Arrays.asList("def"));
        c.setAnAparitie("1990");
        c.setCuvinteCheie(Arrays.asList("c"));
    }

    @Test
    public void ecpValid() {
        try {
            ctrl.adaugaCarte(c);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void ecpInvalid() { // titlu = numar
        c.setTitlu("1");
        try {
            ctrl.adaugaCarte(c);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    public void bvaValid() { // an aparitie = 0
        c.setAnAparitie("0");
        try {
            ctrl.adaugaCarte(c);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void bvaInvalid() { // autori = empty list
        c.setReferenti(new ArrayList<String>());
        try {
            ctrl.adaugaCarte(c);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    public void TC2_ECP() { // an aparitie = negativ
        c.setAnAparitie("-20");
        try {
            ctrl.adaugaCarte(c);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    public void TC3_ECP() {
        c.setAnAparitie("ads");
        try {
            ctrl.adaugaCarte(c);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    public void TC3_BVA() {
        c.setAnAparitie("-1");

        try {
            ctrl.adaugaCarte(c);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    public void TC5_BVA() {
        c.setAnAparitie("1");

        try {
            ctrl.adaugaCarte(c);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

}

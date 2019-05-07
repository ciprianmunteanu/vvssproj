import controller.BibliotecaCtrl;
import domain.Carte;
import org.junit.BeforeClass;
import org.junit.Test;
import repo.CartiRepoMock;
import service.CartiService;

import java.util.Arrays;
import java.util.List;

public class TopDownIntegrationTesting {
    private static CartiService cartiService;
    private static BibliotecaCtrl bibliotecaCtrl;
    private static Carte c1, c2, c3;

    @BeforeClass
    public static void setup() {
        CartiRepoMock cartiRepoMock = new CartiRepoMock();
        cartiService = new CartiService(cartiRepoMock);
        bibliotecaCtrl = new BibliotecaCtrl(cartiService);

        for(Carte c : cartiRepoMock.getCarti()) {
            cartiRepoMock.stergeCarte(c);
        }

        c1 = new Carte("T1", Arrays.asList("Test1"), "1", Arrays.asList("k1"));
        c2 = new Carte("T2", Arrays.asList("Test2", "Test3"), "2", Arrays.asList("k2"));
        c3 = new Carte("T3", Arrays.asList("Test4"), "3", Arrays.asList("k3"));

        cartiRepoMock.adaugaCarte(c1);
        cartiRepoMock.adaugaCarte(c2);
        cartiRepoMock.adaugaCarte(c3);
    }

    @Test
    public void f1() {
        Carte c = new Carte();
        c.setReferenti(Arrays.asList("def"));
        c.setAnAparitie("1990");
        c.setCuvinteCheie(Arrays.asList("c"));
        c.setTitlu("1");
        try {
            bibliotecaCtrl.adaugaCarte(c);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    public void f2() {
        List<Carte> c = cartiService.cautaCarte("Test1");
        assert c.size() == 1;
        assert c.get(0) == c1;
    }

    @Test
    public void f3() {
        List<Carte> r = cartiService.getCartiOrdonateDinAnul("2");
        assert r.size() == 1;
    }

    @Test
    public void f1Int() throws Exception {
        int init = cartiService.getCarti().size();

        Carte crt = new Carte("Int", Arrays.asList("IntAuth"), "1234", Arrays.asList("int k"));
        cartiService.adaugaCarte(crt);
        assert bibliotecaCtrl.getCarti().size() == init + 1;
    }

    @Test
    public void f12Int() throws Exception {
        int init = cartiService.getCarti().size();

        Carte crt = new Carte("Int", Arrays.asList("IntAuthh"), "1235", Arrays.asList("int k"));
        cartiService.adaugaCarte(crt);
        assert bibliotecaCtrl.getCarti().size() == init + 1;

        List<Carte> intAuth = bibliotecaCtrl.cautaCarte("IntAuthh");
        assert intAuth.size() == 1 && intAuth.get(0) == crt;
    }

    @Test
    public void f123Int() throws Exception {
        int init = cartiService.getCarti().size();

        Carte crt = new Carte("Int", Arrays.asList("IntAuthhh"), "1236", Arrays.asList("int k"));
        cartiService.adaugaCarte(crt);
        assert bibliotecaCtrl.getCarti().size() == init + 1;

        List<Carte> intAuth = bibliotecaCtrl.cautaCarte("IntAuthhh");
        assert intAuth.size() == 1 && intAuth.get(0) == crt;

        List<Carte> intAn = bibliotecaCtrl.getCartiOrdonateDinAnul("1236");
        assert intAn.size() == 1 && intAn.get(0) == crt;
    }
}

import controller.BibliotecaCtrl;
import domain.Carte;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import repo.CartiRepoMock;
import service.CartiService;

import java.util.Arrays;
import java.util.List;

public class F2Tests {
    private static CartiService cartiService;
    private static Carte c1, c2, c3;

    @BeforeClass
    public static void setup() {
        CartiRepoMock cartiRepoMock = new CartiRepoMock();
        cartiService = new CartiService(cartiRepoMock);

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
    public void tc01() {
        List<Carte> c = cartiService.cautaCarte("Test1");
        assert c.size() == 1;
        assert c.get(0) == c1;
    }

    @Test
    public void tc02() {
        List<Carte> c = cartiService.cautaCarte("invalid");
        assert c.size() == 0;
    }
}

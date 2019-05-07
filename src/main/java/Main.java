import controller.BibliotecaCtrl;
import repo.CartiRepoInterface;
import repo.CartiRepoMock;
import service.CartiService;
import view.Consola;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CartiRepoInterface repo = new CartiRepoMock();
        CartiService service = new CartiService(repo);
        BibliotecaCtrl controller = new BibliotecaCtrl(service);
        Consola c = new Consola(controller);
        try {
            c.executa();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

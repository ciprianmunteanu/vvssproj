package view;

import controller.BibliotecaCtrl;
import domain.Carte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Consola {
    private BufferedReader console;
    BibliotecaCtrl bibliotecaCtrl;

    public Consola(BibliotecaCtrl bibliotecaCtrl){
        this.bibliotecaCtrl = bibliotecaCtrl;
    }

    public void executa() throws IOException {

        console = new BufferedReader(new InputStreamReader(System.in));

        int opt = -1;
        while(opt!=0){

            switch(opt){
                case 1:
                    adauga();
                    break;
                case 2:
                    cautaCartiDupaAutor();
                    break;
                case 3:
                    afiseazaCartiOrdonateDinAnul();
                    break;
                case 4:
                    afiseazaToateCartile();
                    break;
            }

            printMenu();
            String line;
            do{
                System.out.println("Introduceti un nr:");
                line=console.readLine();
            }while(!line.matches("[0-4]"));
            opt=Integer.parseInt(line);
        }
    }

    public void printMenu(){
        System.out.println("\n\n\n");
        System.out.println("Evidenta cartilor dintr-o biblioteca");
        System.out.println("     1. Adaugarea unei noi carti");
        System.out.println("     2. Cautarea cartilor scrise de un anumit autor");
        System.out.println("     3. Afisarea cartilor din biblioteca care au aparut intr-un anumit an, ordonate alfabetic dupa titlu si autori");
        System.out.println("     4. Afisarea toturor cartilor");
        System.out.println("     0. Exit");
    }

    public void adauga(){
        Carte carteNoua = new Carte();
        try{
            System.out.println("\n\n\n");

            System.out.println("Titlu:");
            carteNoua.setTitlu(console.readLine());

            String line;
            do{
                System.out.println("An aparitie:");
                line=console.readLine();
            }while(!line.matches("[10-9]+"));
            carteNoua.setAnAparitie(line);

            do{
                System.out.println("Nr. de referent:");
                line=console.readLine();
            }while(!line.matches("[1-9]+"));
            int nrReferenti= Integer.parseInt(line);
            for(int i=1;i<=nrReferenti;i++){
                System.out.println("Autor "+i+": ");

                carteNoua.adaugaReferent(console.readLine());
            }

            do{
                System.out.println("Nr. de cuvinte cheie:");
                line=console.readLine();
            }while(!line.matches("[1-9]+"));
            int nrCuv= Integer.parseInt(line);
            for(int i=1;i<=nrCuv;i++){
                System.out.println("Cuvant "+i+": ");
                carteNoua.adaugaCuvantCheie(console.readLine());
            }

            bibliotecaCtrl.adaugaCarte(carteNoua);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void afiseazaToateCartile(){
        System.out.println("\n\n\n");
        try {
            for(Carte c: bibliotecaCtrl.getCarti())
                System.out.println(c);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void cautaCartiDupaAutor(){

        System.out.println("\n\n\n");
        System.out.println("Autor:");
        try {
            for(Carte c: bibliotecaCtrl.cautaCarte(console.readLine())){
                System.out.println(c);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void afiseazaCartiOrdonateDinAnul(){
        System.out.println("\n\n\n");
        try{
            String line;
            do{
                System.out.println("An aparitie:");
                line=console.readLine();
            }while(!line.matches("[10-9]+"));
            for(Carte c: bibliotecaCtrl.getCartiOrdonateDinAnul(line)){
                System.out.println(c);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

package NONALEZIONE.EserciziMattina;

import java.util.ArrayList;
import java.util.Scanner;


class Menu2{
    String ingredienti;
    double prezzo;
    String chef;

    public Menu2(String ingredienti, double prezzo, String chef) {
        this.ingredienti = ingredienti;
        this.prezzo = prezzo;
        this.chef = chef;
    }

}

class Ordinazione2{
    ArrayList<Menu2> piatto;
    double totale;

    public Ordinazione2() {
        this.piatto = new ArrayList<>();
        this.totale = 0;
    }

    public void aggiungiMenu(Menu2 piatto){
        this.piatto.add(piatto);
        this.totale += piatto.prezzo;
    }

    public void stampa(){
        for (Menu2 menu : this.piatto){
            System.out.println(menu.ingredienti + " " + menu.prezzo + " " + menu.chef);
        }
        System.out.println("Totale: " + this.totale);
    }
}


public class Alternativa{

    public static void main(String[] args) {
        Ordinazione2 ordinazione = new Ordinazione2();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Inserisci gli ingredienti del piatto: ");
            String ingredienti = scanner.nextLine();
            System.out.println("Inserisci il prezzo del piatto: ");
            double prezzo = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Inserisci il nome dello chef: ");
            String chef = scanner.nextLine();

            Menu2 menu = new Menu2(ingredienti, prezzo, chef);
            ordinazione.aggiungiMenu(menu);

            System.out.println("Vuoi aggiungere un altro piatto? (s/n)");
            String risposta = scanner.nextLine();
            if (risposta.equals("n")){
                break;
            }
        }

        ordinazione.stampa();
        scanner.close();
    }
}
package NONALEZIONE.EserciziMattina;

import java.util.ArrayList;
import java.util.Scanner;

class Ingrediente {
    private String nome;

    public Ingrediente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {
        return nome;
    }
}

class Piatto {
    private ArrayList<Ingrediente> ingredienti;
    private double prezzo;
    private String chef;

    public Piatto(ArrayList<Ingrediente> ingredienti, double prezzo, String chef) {
        this.ingredienti = ingredienti;
        this.prezzo = prezzo;
        this.chef = chef;
    }

    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "Piatto{" +
                "ingredienti=" + ingredienti +
                ", prezzo=" + prezzo +
                ", chef='" + chef + '\'' +
                '}';
    }
}

class Menu {
    private ArrayList<Piatto> piatti;

    public Menu() {
        this.piatti = new ArrayList<>();
    }

    public void aggiungiPiatto(Piatto piatto) {
        piatti.add(piatto);
        System.out.println("Piatto aggiunto: " + piatto);
    }

    public void stampa() {
        if (piatti.isEmpty()) {
            System.out.println("Il menu è vuoto.");
        } else {
            System.out.println("Menu:");
            for (int i = 1; i < piatti.size(); i++) {
                System.out.println(i + ". " + piatti.get(i));
            }
        }
    }

    public Piatto getPiatto(int index) {
        if (index >= 0 && index < piatti.size()) {
            return piatti.get(index);
        }
        return null;
    }
}

class Ordinazione {
    private ArrayList<Piatto> piattiOrdinati;

    public Ordinazione() {
        this.piattiOrdinati = new ArrayList<>();
    }

    public void aggiungiPiatto(Piatto piatto) {
        piattiOrdinati.add(piatto);
        System.out.println("Piatto ordinato: " + piatto);
    }

    public double calcolaTotale() {
        double totale = 0;
        for (Piatto piatto : piattiOrdinati) {
            totale += piatto.getPrezzo();
        }
        return totale;
    }

    public void stampa() {
        if (piattiOrdinati.isEmpty()) {
            System.out.println("Nessun piatto ordinato.");
        } else {
            System.out.println("Ordinazione:");
            for (Piatto piatto : piattiOrdinati) {
                System.out.println(piatto);
            }
            System.out.println("Totale: " + calcolaTotale() + " euro");
        }
    }
}

public class Esercizio2Polimorfismo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Ordinazione ordinazione = new Ordinazione();

        boolean flag = true;
        while (flag) {
            System.out.println("\nMenu:");
            System.out.println("1. Aggiungi Piatto al Menu");
            System.out.println("2. Stampa Menu");
            System.out.println("3. Aggiungi Piatto all'Ordinazione");
            System.out.println("4. Stampa Ordinazione");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline rimasto nel buffer

            switch (scelta) {
                case 1:
                    aggiungiPiattoAlMenu(scanner, menu);
                    break;
                case 2:
                    menu.stampa();
                    break;
                case 3:
                    aggiungiPiattoAllOrdinazione(scanner, menu, ordinazione);
                    break;
                case 4:
                    ordinazione.stampa();
                    break;
                case 5:
                    System.out.println("Uscita dal sistema.");
                    flag = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
        scanner.close();
    }

    private static void aggiungiPiattoAlMenu(Scanner scanner, Menu menu) {
        System.out.print("Inserisci il nome dello chef: ");
        String chef = scanner.nextLine();
        System.out.print("Inserisci il prezzo del piatto: ");
        double prezzo = scanner.nextDouble();
        scanner.nextLine(); // Consuma il newline rimasto nel buffer

        ArrayList<Ingrediente> ingredienti = new ArrayList<>();
        System.out.println("Inserisci gli ingredienti (digita 'fine' per terminare):");
        while (true) {
            System.out.print("Ingrediente: ");
            String nomeIngrediente = scanner.nextLine();
            if (nomeIngrediente.equalsIgnoreCase("fine")) {
                break;
            }
            ingredienti.add(new Ingrediente(nomeIngrediente));
        }

        Piatto piatto = new Piatto(ingredienti, prezzo, chef);
        menu.aggiungiPiatto(piatto);
    }

    private static void aggiungiPiattoAllOrdinazione(Scanner scanner, Menu menu, Ordinazione ordinazione) {
        menu.stampa();
        System.out.print("Inserisci l'indice del piatto da ordinare: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline rimasto nel buffer
        Piatto piattoOrdinato = menu.getPiatto(indice);
        if (piattoOrdinato != null) {
            ordinazione.aggiungiPiatto(piattoOrdinato);
        } else {
            System.out.println("Indice non valido.");
        }
    }
}
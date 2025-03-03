package SESTALEZIONE;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Prova_Squadra {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Creazione della prima squadra
        Squadra squadra1 = new Squadra();
        System.out.println("Inserisci il nome della prima squadra: ");
        String nomeSquadra1 = in.nextLine();
        inserisciCalciatori(in, squadra1);

        // Creazione della seconda squadra
        Squadra squadra2 = new Squadra();
        System.out.println("Inserisci il nome della seconda squadra: ");
        String nomeSquadra2 = in.nextLine();
        inserisciCalciatori(in, squadra2);

        // Creazione della partita
        Partita partita = new Partita(squadra1, squadra2);
        int risultato1 = partita.giocaPartita();
        int risultato2 = partita.giocaPartita();
        System.out.println("Il risultato della partita tra " + nomeSquadra1 + " e " + nomeSquadra2 + " è: " + risultato1 + "-" + risultato2);

        in.close();
    }

    private static void inserisciCalciatori(Scanner in, Squadra squadra) {
        String nomeCalciatore;
        String ruoloCalciatore;
        for (int i = 1; i < 12; i++) {
            boolean nomeEsistente;
            boolean ruoloEsistente;
            do {
                nomeEsistente = false;
                System.out.println("Inserisci il nome del calciatore: ");
                nomeCalciatore = in.nextLine();
                for (Calciatore c : squadra.rosa) {
                    if (c.nome.equals(nomeCalciatore)) {
                        nomeEsistente = true;
                        System.out.println("Errore: Nome del calciatore già presente. Inserisci un nome diverso.");
                        break;
                    }
                }
            } while (nomeEsistente);

            do {
                ruoloEsistente = false;
                System.out.println("Inserisci il ruolo del calciatore: ");
                ruoloCalciatore = in.nextLine();
                for (Calciatore c : squadra.rosa) {
                    if (c.ruolo.equals(ruoloCalciatore)) {
                        ruoloEsistente = true;
                        System.out.println("Errore: Ruolo del calciatore già presente. Inserisci un ruolo diverso.");
                        break;
                    }
                }
            } while (ruoloEsistente);

            Calciatore calciatore = new Calciatore(nomeCalciatore, ruoloCalciatore);
            squadra.rosa.add(calciatore);
        }
    }

    static class Calciatore {
        String nome;
        String ruolo;

        public Calciatore(String nome, String ruolo) {
            this.nome = nome;
            this.ruolo = ruolo;
        }
    }

    static class Squadra {
        ArrayList<Calciatore> rosa = new ArrayList<Calciatore>(0);
    }

    static class Partita {
        Squadra squadra1;
        Squadra squadra2;
        Random random = new Random();

        public Partita(Squadra squadra1, Squadra squadra2) {
            this.squadra1 = squadra1;
            this.squadra2 = squadra2;
        }

        public int giocaPartita() {
            return random.nextInt(5); // Randomizza un risultato tra 0 e 4
        }
    }
}

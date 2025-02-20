package QUARTALEZIONE.EserciziPomeriggio;

import java.util.*;

public class SistemaPrenotazione {
    public static void main(String[] args) {

        //Creazione delle liste degli elementi da salvare
        Scanner str = new Scanner(System.in);
        Scanner num = new Scanner(System.in);
        ArrayList<String> listaClienti = new ArrayList<String>();
        ArrayList<Integer> listaPostiRiga = new ArrayList<Integer>();
        ArrayList<Integer> listaPostiColonna = new ArrayList<Integer>();

        //inserimenti delle righe e delle colonne in base alle condizioni della traccia
        while (true) {
            System.out.println("Prenotazione di un posto");

            int riga;
            while (true) {
                System.out.print("Inserisci riga tra 1 e 3: ");
                riga = num.nextInt();
                if (riga >= 1 && riga <= 3) {
                    break;
                }
                System.out.println("Errore! La riga deve essere tra 1 e 3.");
            }

            int colonna;
            while (true) {
                System.out.print("Inserisci colonna tra 1 e 8: ");
                colonna = num.nextInt();
                if (colonna >= 1 && colonna <= 8) {
                    break;
                }
                System.out.println("Errore! La colonna deve essere tra 1 e 8.");
            }

            //Verifica che il posto non sia stato gia occupato
            boolean postoOccupato = false;
            for (int i = 0; i < listaPostiRiga.size(); i++) {
                if (listaPostiRiga.get(i) == riga && listaPostiColonna.get(i) == colonna) {
                    postoOccupato = true;
                    break;
                }
            }

            if (postoOccupato) {
                System.out.println("Il posto (" + riga + ", " + colonna + ") è già prenotato. Riprova.");
                continue;
            }

            //inserimento del cliente e verifica che il cliente non sia nullo
            System.out.print("Inserisci il nome del cliente: ");
            String cliente = str.nextLine().trim();

            //assegnazione di quel cliente a quella posizione e stampa della prenotazione confermata
            if (cliente.length() > 0) {
                listaClienti.add(cliente);
                listaPostiRiga.add(riga);
                listaPostiColonna.add(colonna);
                System.out.println("Prenotazione confermata per " + cliente + " nel posto (" + riga + ", " + colonna + ").");
            } else {
                System.out.println("Errore! Il nome non può essere vuoto.");
                continue;
            }

            //richiesta di un'altra prenotazione
            System.out.println("Vuoi aggiungere un'altra prenotazione? (si/no): ");
            String risposta = str.nextLine().trim().toLowerCase();
            if (!risposta.equals("si")) {
                break;
            }
        }

        //stampa riepilogo prenotazioni
        System.out.println("Riepilogo Prenotazioni");
        for (int i = 0; i < listaClienti.size(); i++) {
            System.out.println(listaClienti.get(i) + " ha prenotato il posto (" + listaPostiRiga.get(i) + ", " + listaPostiColonna.get(i) + ").");
        }

        System.out.println("Programma terminato.");
        str.close();
        num.close();
    }
}

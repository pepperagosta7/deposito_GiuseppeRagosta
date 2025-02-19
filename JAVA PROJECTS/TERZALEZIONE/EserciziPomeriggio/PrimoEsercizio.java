package TERZALEZIONE.EserciziPomeriggio;

import java.util.Scanner;

public class PrimoEsercizio {
    
    public static void main(String[] args){

        //creazione delle variabili e dello scanner 
        int x;
        int somma = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("inserisci tanti numeri positivi quanti ne vuoi. inserisci un numero negativo per annullare la richiesta");

        //verifica che il primo inserimento avvenga e dopo aggiorna la variabile somma con il nuovo intero inserito
        do {
            x = in.nextInt();
            if (x >= 0) {
                somma += x;
            }
        } while (x >= 0);

        System.out.println(somma);

        in.close();
    }
}

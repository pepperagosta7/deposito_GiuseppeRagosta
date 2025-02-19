package TERZALEZIONE.EserciziPomeriggio;

import java.util.Random;
import java.util.Scanner;

public class TaskExtra {

    public static void main(String [] args){

        Scanner in = new Scanner(System.in);
        System.out.println("scegli cosa esguire inserendo un numero da 1 a 3");

        int scelta = in.nextInt();
        switch (scelta){
            case 1:

                //creazione delle variabili e del primo scanner 
                int x;
                int somma = 0;
                Scanner first = new Scanner(System.in);
        
                System.out.println("inserisci tanti numeri positivi quanti ne vuoi. inserisci un numero negativo per annullare la richiesta");
        
                //verifica che il primo inserimento avvenga e dopo aggiorna la variabile somma con il nuovo intero inserito
                do {
                    x = first.nextInt();
                    if (x >= 0) {
                        somma += x;
                    }
                } while (x >= 0);
        
                System.out.println(somma);
        
                first.close();
                break;
            
            case 2:
                
                
                Scanner second = new Scanner(System.in);
                System.out.println("Inserisci un numero intero");
        
                //inserimento del numero e moltiplicazione fino a 10 con counter "moltiplicazione" che si aggiorna a ogni iterazione fino a 10
                int y = second.nextInt();
                int moltiplicazione=1;
                while(moltiplicazione <= 10){
                    System.out.println(y*moltiplicazione);
                    moltiplicazione++;
                }
        
                second.close();
                break;
            
            case 3:
                    System.out.println("GIOCHIAMO! Ora genero un numero da 1 a 100 e tu dovrai indovinarlo.");
                    Random rand = new Random();
                    int numCasuale = rand.nextInt(100)+1;

                    //utente inserisce un numero
                    Scanner third = new Scanner(System.in);
                    System.out.println("Inserisci un numero da 1 a 100");
                    int numeroUtente = third.nextInt();

                    //verifica della corrispondenza dei numeri finchè non sono uguali
                    while (numeroUtente != numCasuale){
                        if (numeroUtente <= numCasuale){
                            System.out.println("Troppo basso, inserisci un nuovo numero.");
                            numeroUtente = third.nextInt();
                        }
                        else {
                            System.out.println("Troppo alto, inserisci un nuovo numero.");
                            numeroUtente = third.nextInt();
                        }
                    }

                    //corrispondenza trovata
                    if (numeroUtente == numCasuale){
                        System.out.println("Congratulazioni, vuoi giocare ancora?");
                    }

                    third.close();
                    break;

                }

        in.close();
    }
    
}

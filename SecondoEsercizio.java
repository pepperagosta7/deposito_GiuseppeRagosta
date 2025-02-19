package TERZALEZIONE.EserciziPomeriggio;

import java.util.Scanner;

public class SecondoEsercizio {
    
    public static void main(String [] args){

        //creazione dello scanner
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci un numero intero");

        //inserimento del numero e moltiplicazione fino a 10 con counter "moltiplicazione" che si aggiorna a ogni iterazione fino a 10
        int x = in.nextInt();
        int moltiplicazione=1;
        while(moltiplicazione <= 10){
            System.out.println(x*moltiplicazione);
            moltiplicazione++;
        }

        in.close();
    }
}

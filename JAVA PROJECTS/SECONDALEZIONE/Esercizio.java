package SECONDALEZIONE;

import java.util.Random;
import java.util.Scanner;

public class Esercizio {
    
    public static void main(String[] args){

        //creazione di scanner e inzializzazione della variabile del numero corretto
        Scanner in = new Scanner(System.in);
        //int conteggioOperazioni = 0;
        int numerocorretto = 0;

        //scelta dell'operazione
        System.out.println("cosa vuoi far enel menu 1- +  2 -  3 - *  4 - /");
        int scelta_menu = in.nextInt();
    
        if(scelta_menu == 1) {
            System.out.println("aggiungi addendo 1");
            int addendo1 = in.nextInt();
            System.out.println("aggiungi addendo 2");
            int addendo2 = in.nextInt();
            numerocorretto = addendo1 + addendo2;
            System.out.println(numerocorretto);
        }
        else if(scelta_menu == 2) {
            System.out.println("aggiungi addendo 1");
            int addendo1 = in.nextInt();
            System.out.println("aggiungi addendo 2");
            int addendo2 = in.nextInt();
            numerocorretto = addendo1 - addendo2;
            System.out.println(numerocorretto);
        }
        else if(scelta_menu == 3){
            System.out.println("aggiungi addendo 1");
            int addendo1 = in.nextInt();
            System.out.println("aggiungi addendo 2");
            int addendo2 = in.nextInt();
            numerocorretto = addendo1 * addendo2;
            System.out.println(numerocorretto);
        }
        else if(scelta_menu == 4){
            System.out.println("aggiungi addendo 1");
            int addendo1 = in.nextInt();
            System.out.println("aggiungi addendo 2");
            int addendo2 = in.nextInt();
            if(addendo2 == 0){
                numerocorretto = addendo1/addendo2;
                System.out.println(numerocorretto);
            }
        }
        else{ 
            System.out.println("coglione");
        }
        //generazione numero randomico e somma dei risultati
        Random rand = new Random();
        int numeroCasuale = rand.nextInt(100);
        int risultatoErrato = numerocorretto + numeroCasuale;
        System.out.println(risultatoErrato);

        //System.out.println("Hai eseguito " + conteggioOperazioni + " operazioni. Grazie per aver usato il programma!");
        in.close();
    }
}

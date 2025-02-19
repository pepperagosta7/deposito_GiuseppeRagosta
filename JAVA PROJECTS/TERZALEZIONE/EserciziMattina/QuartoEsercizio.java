package TERZALEZIONE.EserciziMattina;

import java.util.Scanner;

public class QuartoEsercizio {
    
    public static void main(String[] args){

        //creazione dello scanner
        Scanner in =  new Scanner(System.in);
        System.out.println("Inserisci un anno: ");

        //inserimento dell'anno
        int anno = in.nextInt();

        //calcolo dell'anno ed esito
        if((anno % 4 == 0 && anno % 100 != 0) || (anno % 400 == 0)){
            System.out.println("L'anno è bisestile");
        }
        else {
            System.out.println("L'anno non è bisestile");
        }
        
        in.close();
    }
}

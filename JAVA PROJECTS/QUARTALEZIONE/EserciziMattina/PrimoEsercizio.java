package QUARTALEZIONE.EserciziMattina;

import java.util.Scanner;

public class PrimoEsercizio {
    
    public static void main(String[] args){

        // creazione scanner
        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci un numero intero: ");
        int exit = in.nextInt();

        // controllo che il numero sia positivo
        while(exit > 0){

            if (exit % 2 == 0){
                System.out.println(exit + " è pari");
                exit = in.nextInt();
            }
            else{
                System.out.println(exit + " è dispari");
                exit = in.nextInt();
            }

            if (exit < 0) {
                System.out.println(exit + " è un numero negativo");
                break;
            }
        }

        in.close();
    }
}

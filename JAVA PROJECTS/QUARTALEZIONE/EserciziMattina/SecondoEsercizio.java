package QUARTALEZIONE.EserciziMattina;

import java.util.Scanner;

public class SecondoEsercizio {
    
    public static void main(String[] args){

        // creazione scanner e inizializzazione dell'array
        Scanner in = new Scanner(System.in);
        int array[] = {0,0,0,0,0,0,0};
        
        //scorrimento dell'array per fare uso dello switch per scegliere i giorni della settimana
        for (int i = 0; i<array.length; i++){
            System.out.print("Inserisci un numero da 0 a 6: ");
            array[i] = in.nextInt() % 7;
            switch (array[i]){
                case 0:
                    System.out.println("Hai scelto Lunedì");
                    break;
                case 1:
                    System.out.println("Hai scelto Martedì");
                    break;
                case 2:
                    System.out.println("Hai scelto Mercoledì");
                    break;
                case 3:
                    System.out.println("Hai scelto Giovedì");
                    break;
                case 4:
                    System.out.println("Hai scelto Venerdì");
                    break;
                case 5:
                    System.out.println("Hai scelto Sabato");
                    break;
                case 6:
                    System.out.println("Hai scelto Domenica");
                    break;
                default:
                    break;
            }
        }

        //stampa della lista dei giorni scelti dopo aver riempito l'array
        System.out.println("Hai selezionato i seguenti giorni: ");
        for (int giorno : array){
            switch (giorno) {
                case 0:
                    System.out.println("Lunedi");
                    break;
                case 1:
                    System.out.println("Martedi");
                    break;
                case 2:
                    System.out.println("Mercoledi");
                    break;
                case 3:
                    System.out.println("Giovedi");
                    break;
                case 4:
                    System.out.println("Venerdi");
                    break;
                case 5:
                    System.out.println("Sabato");
                    break;
                case 6:
                    System.out.println("Domenica");
                    break;

                default:
                    System.out.println("error");
                    break;
            }

        }
        in.close();
    }
}

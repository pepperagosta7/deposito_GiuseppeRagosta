package TERZALEZIONE.EserciziPomeriggio;

import java.util.Scanner;

public class QuartoEsercizio {
    
    public static void main(String[] args){

        //creazione scanner
        Scanner in = new Scanner(System.in);
        Scanner num = new Scanner(System.in);

        //richiesta credenziali
        System.out.println("inserisci nome");
        String nome = in.nextLine();

        System.out.println("inserisci password");
        String password = in.nextLine();

        System.out.println("inserisce eta");
        int eta = num.nextInt();

        do {
            //reinserimento delle credenziali
            for (int i = 1; i <= 3; i++){
                System.out.println("Inserisci nuovamente nome");
                String nuovoNome = in.nextLine(); 

                System.out.println("inserisci nuovamente password");
                String nuovoPassword = in.nextLine();

                System.out.println("inserisci nuovamente eta");
                int nuovaEta = num.nextInt();  
                
                //controllo della corrispondenza delle credenziali
                if (nome.equals(nuovoNome) && password.equals(nuovoPassword) && eta == nuovaEta){

                    System.out.println("tutto apposto");
                }
                else {
                    System.out.println("error");
                }
            }
        }while (nome != null && password != null && eta!=0);

        in.close();
        num.close();
    }
}

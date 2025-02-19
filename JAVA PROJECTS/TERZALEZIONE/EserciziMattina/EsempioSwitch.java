package TERZALEZIONE.EserciziMattina;

import java.util.Scanner;

public class EsempioSwitch {
    
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci un numero da 1 a 7.");

        int day = in.nextInt();
        switch(day){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wendsday");
                break;
            default:
                System.out.println("a semman ancor adda frnì");
                break;
        }

        in.close();

        int time = 20;
        String result = (time < 18)? "Good day" : "Good evening";
        System.out.println(result);
    }
}

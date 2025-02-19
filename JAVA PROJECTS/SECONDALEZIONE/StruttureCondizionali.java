package SECONDALEZIONE;

import java.util.Scanner;

public class StruttureCondizionali {
    
    public static void main(String[] agrs){

        if (20>18){
            System.out.println("tuttappost");
        }

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();

        if (x>y){
            System.out.println("tuttappost");
        }
        else if(x==y){
            System.out.println("tutt ugual");
        }
        else{
            System.out.println("nunètuttappost");
        }

        in.close();
    }
}

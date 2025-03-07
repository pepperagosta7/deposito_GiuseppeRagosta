package DECIMALEZIONE.EserciziMattina;

import java.lang.annotation.*;
import java.lang.reflect.*;

// 1. Definiamo l'annotazione
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface InforAutore{
    String nome();
    String data();
}

// 2. Utilizziamo l'annotazione nella classe
class RicettaCioccolato{

    @InforAutore(nome="Mario Rossi", data="2025-03-01")
    public void preparaCioccolato(){
        System.out.println("Preparazione cioccolato");
    }
}

// 3. Possiamo ispezionare l'annotazione a runtime tramite reflection
public class ProvaAnnotazioni {
    public static void main(String[] args) {
        try{
            Class<?> c = Class.forName("DECIMALEZIONE.RicettaCioccolato");
            for(Method method : c.getDeclaredMethods()){
                if(method.isAnnotationPresent(InforAutore.class)){
                    InforAutore info = method.getAnnotation(InforAutore.class);
                    System.out.println("Metodo: " + method.getName());
                    System.out.println("Autore: " + info.nome() + " Data: " + info.data());
                }
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

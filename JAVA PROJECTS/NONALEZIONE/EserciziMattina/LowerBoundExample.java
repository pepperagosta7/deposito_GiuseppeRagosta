package NONALEZIONE.EserciziMattina;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundExample {
    
    public static void addInteger(List<? super Integer> list){
        list.add(42);
        //list.add(3.14);; // Errore di compilazione! perchè sa sicuramente che è un integer ma non può sapere che altro tipo può essere
       
    }

    public static void main(String[] args) {
        List<Number> numberList = new java.util.ArrayList<>();
        addInteger(numberList);
        System.out.println("numberList: " + numberList);

        List<Object> objectList = new ArrayList<>();
        addInteger(objectList);
        System.out.println("objectList: " + objectList);

        // Lista di Integer: Integer è il tipo base richiesto dalla classe.
        // List<Integer> intList = new ArrayList<>();
        // addInteger(intList);
    }
}



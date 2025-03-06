package NONALEZIONE.EserciziMattina;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundExample {
    
    public static void printNumbers(List<? extends Number> numbers){
        for(Number number : numbers){
            System.out.println(number);
        }
        // numbers.add(3.14); // NON COMPILA: non è possibile aggiungere elementi. numbers è in read-only perché ancora non sa che tipo di elementi contiene
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(3.14);
        doubleList.add(2.71);

        printNumbers(intList);
        printNumbers(doubleList);

    }
}

package NONALEZIONE.EserciziMattina;

public class ProvaWrapper {
    public static void main(String[] args) {
        Integer myInt = 50;
        Double myDouble = 5.99;
        Character myChar = 'A';
        System.out.println(myInt.intValue());
        System.out.println(myDouble.doubleValue()); 
        System.out.println(myChar.charValue());

        String myString = myInt.toString();
        System.out.println(myString.length());
    }
}

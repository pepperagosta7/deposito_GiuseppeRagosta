package NONALEZIONE.EserciziMattina;

public class ProvaGenerics <T> {
    
    T valueToPrint;

    public ProvaGenerics(T valueToPrint) {
        this.valueToPrint = valueToPrint;
    }

    public void printValue() {
        System.out.println("Valore da stampare: " + valueToPrint);
    }

    public static void main(String[] args) {
        ProvaGenerics<String> provaGenerics = new ProvaGenerics<>("Hello, World!");
        provaGenerics.printValue();

        ProvaGenerics<Integer> provaGenerics1 = new ProvaGenerics<>(42);
        provaGenerics1.printValue();
        
    }
}

package NONALEZIONE.EserciziMattina;

public class ProvaBoundedType <T extends Number> {
    
    T valueToPrint;

    public ProvaBoundedType(T valueToPrint) {
        this.valueToPrint = valueToPrint;
    }

    public void printValue() {
        System.out.println("Valore da stampare: " + valueToPrint);
    }

    public static void main(String[] args) {
        try{
            ProvaBoundedType<Integer> provaBoundedType = new ProvaBoundedType<>(42);
            provaBoundedType.printValue();

            ProvaBoundedType<Double> provaBoundedType1 = new ProvaBoundedType<>(42.0);
            provaBoundedType1.printValue();

            //ProvaBoundedType<String> provaBoundedType1 = new ProvaBoundedType<>("Hello, World!");
            //provaBoundedType1.printValue();
        }catch(Exception e){
            System.out.println("Errore: " + e);
        }
    } 
}

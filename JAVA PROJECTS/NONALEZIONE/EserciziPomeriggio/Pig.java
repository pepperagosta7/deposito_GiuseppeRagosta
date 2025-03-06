package NONALEZIONE.EserciziPomeriggio;

public class Pig implements Animal{
    @Override
    public void animalSound(){
        System.out.println("The pig says: wee wee");
    }
    @Override
    public void dormi(){
        System.out.println("Zzz");
    }
}


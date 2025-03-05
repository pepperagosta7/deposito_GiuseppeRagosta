package OTTAVALEZIONE.EserciziMattina;

public class Prova_Ereditarietà extends Vehicle{
    private String modelName = "Mustang";
    public static void main(String[] args) {
        Prova_Ereditarietà myCar = new Prova_Ereditarietà();
        myCar.honk();
        System.out.println(myCar.brand + " " + myCar.modelName);
    }
    

}

class Vehicle{

    protected String brand = "Ford";
    public void honk(){
        System.out.println("Tuut, tuut!");
    }
}
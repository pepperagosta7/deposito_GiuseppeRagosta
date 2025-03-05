package OTTAVALEZIONE.EserciziMattina;

public class Bike2 extends Veicolo{
    @Override
    void run(){System.out.println( "La bici sta correndo in sicurezza" );} //metodo della classe genitore
    public static void main(String args[]){
    Bike2 obj = new Bike2(); //crea oggetto
    obj.run();
    }
}

//Il metodo run() della classe Bike2 sovrascrive il metodo run() della classe Veicolo.
class Veicolo{
    // //Creazione di una classe genitore. definire un metodo
    void run(){System.out.println( "Il veicolo è in marcia" );}
    }
    
/*public class Bike2 extends Veicolo{
    public static void main(String args[]){
    Bike obj = new Bike();
    obj.run();
    } 
}
*/
package SETTIMALEZIONE.EserciziPomeriggio;

public class Prova_Incapsulamento {
 
    static void myStaticMethod(){
        System.out.println("Static methods can be called without creating objects");
    }

    public void myPublicMethod(){
        System.out.println("Public methods must be called by creating objects");
    }

    public static void main(String[] args) {
        myStaticMethod();
        //myPublicMethod(); // errore

        Prova_Incapsulamento myObj = new Prova_Incapsulamento();
        myObj.myPublicMethod();
        Person myPerson = new Person();
        myPerson.setName("John");
        System.out.println(myPerson.getName());
    }
}

class Person{
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }
}
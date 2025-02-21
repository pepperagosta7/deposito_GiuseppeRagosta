package QUINTALEZIONE.EserciziMattina;

public class EsempioStringhe {
    

    public static void main(String[] args){

        String txt = "Hello World";
        System.out.println(txt.toUpperCase());   // Outputs "HELLO WORLD"
        System.out.println(txt.toLowerCase());   // Outputs "hello world"

        String txt2 = "Please locate where 'locate' occurs!";
        System.out.println(txt2.indexOf("locate")); // Outputs 7

        String firstName = "John";
        String lastName = "Doe";
        System.out.println(firstName + " " + lastName); // Outputs "John Doe"
        System.out.println(firstName.concat(lastName)); // Outputs "JohnDoe"
        
        String txt3 = "We are the so-called \"Vikings\" from the north.";
        System.out.println(txt3); // Outputs "We are the so-called "Vikings" from the north."
    }
}

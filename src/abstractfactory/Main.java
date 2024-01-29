package abstractfactory;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws Exception {

        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Valitse vaatemerkki: ");
        for(VaateMerkki merkki : VaateMerkki.values()) {
            System.out.println(merkki.ordinal() + ": " + merkki);
        }

        System.out.print("> ");
        int valinta = lukija.nextInt();
        lukija.close();

        VaateMerkki merkki = VaateMerkki.values()[valinta];

        Jasper.pueVaatteet(merkki);
        Jasper.listaaVaatteet();
    }
}

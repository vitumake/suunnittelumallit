package composite;

import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        Komponentti kotelo = new Kotelo(100);
        Komponentti muisti = new Muisti(50);
        Komponentti psu = new Psu(150);
        Komponentti prosessori = new Prosessori(200);
        Komponentti emolevy = new Emolevy(100);
        Komponentti kiintolevy = new Kiintolevy(100);
        
        List<Komponentti> komponentit = List.of(kotelo, muisti, psu, prosessori, emolevy, kiintolevy);
        
        Tietokone tietokone = new Tietokone("Tietokone", komponentit);

        tietokone.tulostaKokoonpano();
    }
}

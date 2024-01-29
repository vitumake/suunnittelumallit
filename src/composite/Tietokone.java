package composite;

import java.util.List;

public class Tietokone implements Kokoonpano {
    
    private String nimi;
    private double hinta;
    private List<Komponentti> komponentit;

    public Tietokone(String nimi, List<Komponentti> komponentit) {
        this.nimi = nimi;
        this.komponentit = komponentit;
        this.hinta = this.getHinta();
    }

    public void tulostaKokoonpano() {
        System.out.println(nimi + " " + hinta + "e");
        komponentit.forEach(Kokoonpano::tulostaKokoonpano);
    }

    public double getHinta() {
        return this.komponentit.stream().mapToDouble(k -> k.getHinta()).sum();
    }
}

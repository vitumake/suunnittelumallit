package composite;

abstract class Komponentti implements Kokoonpano {
    
    protected double hinta;
    protected String nimi;

    public Komponentti(double hinta, String nimi) {
        this.nimi = nimi;
        this.hinta = hinta;
    }

    public void tulostaKokoonpano() {
        System.out.println(nimi + " " + hinta + "e");
    }

    public double getHinta() {
        return hinta;
    }

}

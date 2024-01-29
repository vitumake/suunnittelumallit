package abstractfactory;

abstract public class VaateTehdas {
    
    VaateTehdas(VaateMerkki merkki) {
        this.merkki = merkki;
    }

    VaateMerkki merkki;

    public Vaate tilaaVaate(VaateTyyppi tyyppi) {
        Vaate vaate = null;
        switch(tyyppi) {
            case Lippis:
                vaate = new Lippis(merkki);
                break;
            case Tpaita:
                vaate = new Tpaita(merkki);
                break;
            case Farmarit:
                vaate = new Farmarit(merkki);
                break;
            case Kengat:
                vaate = new Kengät(merkki);
                break;
        }
        return vaate;
    }
}

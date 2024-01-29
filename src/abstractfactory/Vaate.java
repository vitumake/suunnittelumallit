package abstractfactory;

abstract class Vaate {

    Vaate (VaateMerkki merkki) {
        this.merkki = merkki;
    }
    
    VaateMerkki merkki;

    public abstract String toString();
}

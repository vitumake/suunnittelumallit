package abstractfactory;

public  class Tpaita extends Vaate{
    
    Tpaita (VaateMerkki merkki) {
        super(merkki);
    }

    public String toString() {
        return merkki + " t-paita";
    }
}

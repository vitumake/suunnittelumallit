package abstractfactory;

public class Farmarit extends Vaate {
    
    Farmarit (VaateMerkki merkki) {
        super(merkki);
    }

    @Override
    public String toString() {
        return merkki + " farmarit";
    }
}

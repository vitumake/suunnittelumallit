package abstractfactory;

public class Lippis extends Vaate {
    
    Lippis (VaateMerkki merkki) {
        super(merkki);
    }

    @Override
    public String toString() {
        return merkki + " lippis";
    }
}

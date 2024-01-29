package abstractfactory;

public class Kengät extends Vaate {
   
    Kengät (VaateMerkki merkki) {
        super(merkki);
    }

    @Override
    public String toString() {
        return merkki + " kengät";
    }
}

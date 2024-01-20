package factorymethod;

public class Talkkari extends AterioivaOtus {

    public Juoma createJuoma() {
        return new Piimä();    
    }
}
package command;

public class Valkokoangas {
    
    Boolean state = false;

    public void open() {
        state = true;
    }

    public void close() {
        state = false;
    }

    @Override
    public String toString() {
        return "Valkokangas on " + (state ? "Alhaalla" : "Ylhäällä");
    }
}

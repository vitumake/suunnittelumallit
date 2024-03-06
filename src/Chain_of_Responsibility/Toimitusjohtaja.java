package Chain_of_Responsibility;

public class Toimitusjohtaja extends Esimies {
    
    public Toimitusjohtaja(int maxRaise) {
        this.maxRaise = maxRaise;
        this.nimike = "Toimitusjohtaja";
    }
}

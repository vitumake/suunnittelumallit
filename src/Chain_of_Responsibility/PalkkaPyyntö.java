package Chain_of_Responsibility;

public class PalkkaPyyntö {

    private int amount; // Prosenttia

    public PalkkaPyyntö(double palkka, double palkankorotus) {
        this.amount = (int) (palkankorotus / palkka * 100);
    }

    public double getAmount() {
        return amount;
    }
}

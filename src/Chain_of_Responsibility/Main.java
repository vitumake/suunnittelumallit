package Chain_of_Responsibility;

public class Main {
    
    public static void main(String[] args) {
        
        // Create the chain of responsibility
        Esimies toimitusjohtaja = new Toimitusjohtaja(0);
        Esimies yksikönpäällikkö = new Yksikönpäällikkö(5);
        Esimies lähiesimies = new Lähiesimies(2);
        
        // Set the chain of responsibility
        lähiesimies.setSuccessor(yksikönpäällikkö);
        yksikönpäällikkö.setSuccessor(toimitusjohtaja);
        
        // Create a requests
        PalkkaPyyntö palkkaPyyntö = new PalkkaPyyntö(1000, 100);
        
        // Process the requests
        lähiesimies.processRequest(palkkaPyyntö);
    }
}

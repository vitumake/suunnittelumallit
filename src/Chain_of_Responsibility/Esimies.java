package Chain_of_Responsibility;

public class Esimies extends JohtoPorras {
    
    protected String nimike;

    @Override
    public void processRequest(PalkkaPyyntö request) {
        if (request.getAmount() <= maxRaise || maxRaise == 0){
            System.out.println(nimike + ": Palkankorotus hyväksytty " + request.getAmount() + "%");
        } else if (successor != null) {
            System.out.println(nimike + ": Pyyntö siirretty eteenpäin");
            successor.processRequest(request);
        } else {
            System.out.println(nimike + ": Palkankorotus hylätty " + request.getAmount() + "%");
        }
    }
}

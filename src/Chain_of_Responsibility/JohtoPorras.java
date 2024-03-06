package Chain_of_Responsibility;

abstract class JohtoPorras {
    
    protected JohtoPorras successor;
    protected int maxRaise;

    public void setSuccessor(JohtoPorras successor) {
        this.successor = successor;
    }

    public abstract void processRequest(PalkkaPyyntö request);
}
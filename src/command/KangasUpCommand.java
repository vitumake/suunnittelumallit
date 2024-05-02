package command;

public class KangasUpCommand implements Command {
    
    private Valkokoangas valkokoangas;

    public KangasUpCommand(Valkokoangas valkokoangas) {
        this.valkokoangas = valkokoangas;
    }

    @Override
    public void execute() {
        valkokoangas.close();
    }
}

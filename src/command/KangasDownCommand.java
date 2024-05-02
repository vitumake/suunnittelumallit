package command;

public class KangasDownCommand implements Command {
    
    private Valkokoangas valkokoangas;

    public KangasDownCommand(Valkokoangas valkokoangas) {
        this.valkokoangas = valkokoangas;
    }

    @Override
    public void execute() {
        valkokoangas.open();
    }
}

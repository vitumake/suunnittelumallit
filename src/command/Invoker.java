package command;

public class Invoker {
    Command command;

    public void setCommnad(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

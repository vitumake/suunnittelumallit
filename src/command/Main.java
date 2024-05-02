package command;

public class Main {
    
    public static void main(String[] args) {
        Valkokoangas valkokoangas = new Valkokoangas();
        KangasUpCommand kangasUpCommand = new KangasUpCommand(valkokoangas);
        KangasDownCommand kangasDownCommand = new KangasDownCommand(valkokoangas);
        Invoker nappi = new Invoker();
        
        nappi.setCommnad(kangasUpCommand);
        nappi.executeCommand();
        System.out.println(valkokoangas);
        
        nappi.setCommnad(kangasDownCommand);
        nappi.executeCommand();
        System.out.println(valkokoangas);
    }
}

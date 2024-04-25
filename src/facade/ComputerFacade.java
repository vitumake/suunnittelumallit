package facade;

public class ComputerFacade {
    
    private Cpu cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
        this.cpu = new Cpu(memory);
    }

    public void start() {
        cpu.freeze();
        
        // Load all data from hard drive to memory
        for (long i = 0; i < 10; i++) {
            memory.load(i, hardDrive.read(i, 1024));
        }
        
        // Print all data from memory
        long pos = 0;
        while(true) {
            try {
                cpu.jump(pos++);
                cpu.execute();
            } catch (RuntimeException e) {
                break;
            }
        }
    }
}

package facade;

public class Cpu {

    Memory memory;
    long position;

    public Cpu(Memory memory) {
        this.memory = memory;
    }

    public void freeze() {
        System.out.println("Freezing processor");
    }

    public void jump(long position) {
        System.out.println("Jumping to position " + position);
        this.position = position;

        // If data does not exist throw exception
        if (memory.read(position, 1024) == null) {
            throw new RuntimeException("Data does not exist");
        }
    }

    public void execute() {
        System.out.println("Executing");
        System.out.println("Data: " + memory.read(position, 1024));
    }
}

package builder;

abstract class Ingridient {
    
    private String name;

    public Ingridient(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}

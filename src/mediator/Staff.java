package mediator;

abstract class Staff {
    
    private Mediator mediator;
    private String title;

    public Staff(Mediator mediator, String title) {
        this.mediator = mediator;
        this.title = title;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(this, message);
    }

    public void resieveMessage(String message) {
        System.out.println(title + " received message: " + message);
    }

    public String getTitle() {
        return title;
    }
}

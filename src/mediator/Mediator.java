package mediator;

interface Mediator {
    
    void registerStaff(Staff staff);
    void sendMessage(Staff sender, String message);
}

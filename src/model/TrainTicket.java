package model;

// Kelas tiket kereta
public class TrainTicket implements Ticket {
    private String destination;
    private double price;

    public TrainTicket(String destination, double price) {
        this.destination = destination;
        this.price = price;
    }

    // Implementasi method pada interface Ticket

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

package model;

// Implementasi kelas abstrak TicketFactory menggunakan Abstract Factory Pattern
public class TrainTicketFactory extends TicketFactory {
    @Override
    public Ticket createTicket(String destination, double price) {
        return new TrainTicket(destination, price);
    }
}
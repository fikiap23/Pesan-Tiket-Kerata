package model;

// Kelas abstrak untuk pembuatan objek tiket
public abstract class TicketFactory {
    public abstract Ticket createTicket(String destination, double price);
}

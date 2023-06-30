package model;

import java.util.*;

// Kelas jadwal tiket
public class Schedule {
    private List<Ticket> tickets;

    public Schedule() {
        this.tickets = new ArrayList<>();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    public void displaySchedule() {
        System.out.println("=== JADWAL DAN HARGA TIKET ===");
        int i = 1;
        for (Ticket ticket : tickets) {
            System.out.println(i + ". Tujuan: " + ticket.getDestination() + ", Harga: " + ticket.getPrice());
            i++;
        }
    }
}

package model;

import java.util.ArrayList;
import java.util.List;

import interfaces.Ticket;

/**
 * Kelas jadwal tiket.
 */
public class Schedule {
    private List<Ticket> tickets;

    public Schedule() {
        this.tickets = new ArrayList<>();
    }

    /**
     * Mengembalikan daftar tiket.
     *
     * @return daftar tiket.
     */
    public List<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Menambahkan tiket ke jadwal.
     *
     * @param ticket tiket yang akan ditambahkan.
     */
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    /**
     * Menghapus tiket dari jadwal.
     *
     * @param ticket tiket yang akan dihapus.
     */
    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    /**
     * Menampilkan jadwal dan harga tiket.
     */
    public void displaySchedule() {
        System.out.println("=== JADWAL DAN HARGA TIKET ===");
        int i = 1;
        for (Ticket ticket : tickets) {
            System.out.println(i + ". Tujuan: " + ticket.getDestination() + ", Harga: " + ticket.getPrice());
            i++;
        }
    }
}

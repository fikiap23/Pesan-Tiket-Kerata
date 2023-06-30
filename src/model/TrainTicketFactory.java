package model;

import interfaces.Ticket;

/**
 * Implementasi kelas abstrak TicketFactory menggunakan Abstract Factory
 * Pattern.
 */
public class TrainTicketFactory extends TicketFactory {
    /**
     * Membuat objek tiket kereta dengan tujuan dan harga tertentu.
     *
     * @param destination tujuan tiket kereta.
     * @param price       harga tiket kereta.
     * @return objek tiket kereta.
     */
    @Override
    public Ticket createTicket(String destination, double price) {
        return new TrainTicket(destination, price);
    }
}

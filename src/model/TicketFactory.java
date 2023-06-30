package model;

import interfaces.Ticket;

/**
 * Kelas abstrak untuk pembuatan objek tiket.
 */
public abstract class TicketFactory {
    /**
     * Membuat objek tiket dengan tujuan dan harga tertentu.
     *
     * @param destination tujuan tiket.
     * @param price       harga tiket.
     * @return objek tiket.
     */
    public abstract Ticket createTicket(String destination, double price);
}

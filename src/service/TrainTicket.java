package service;

import interfaces.Ticket;
import interfaces.TicketType;

/**
 * Enum yang menyimpan tipe tiket kereta.
 */

/**
 * Kelas tiket kereta.
 */
public class TrainTicket implements Ticket {
    private String destination;
    private double price;
    private TicketType type;

    public TrainTicket(String destination, double price, TicketType type) {
        this.destination = destination;
        this.price = price;
        this.type = type;
    }

    /**
     * Mengembalikan tujuan tiket kereta.
     *
     * @return tujuan tiket kereta.
     */
    @Override
    public String getDestination() {
        return destination;
    }

    /**
     * Mengembalikan harga tiket kereta.
     *
     * @return harga tiket kereta.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Mengembalikan tipe tiket kereta.
     *
     * @return tipe tiket kereta.
     */
    public TicketType getType() {
        return type;
    }

    @Override
    public TicketType geType() {
        return type;
    }
}

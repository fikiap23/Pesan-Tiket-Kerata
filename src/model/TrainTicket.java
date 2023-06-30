package model;

import interfaces.Ticket;

/**
 * Kelas tiket kereta.
 */
public class TrainTicket implements Ticket {
    private String destination;
    private double price;

    public TrainTicket(String destination, double price) {
        this.destination = destination;
        this.price = price;
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
}

package service;

import interfaces.Ticket;
import interfaces.TicketType;

/**
 * Kelas Factory untuk membuat tiket kereta.
 */
public class TrainTicketFactory {
    /**
     * Membuat tiket kereta ekonomi.
     *
     * @param destination tujuan tiket
     * @param price       harga tiket ekonomi
     * @return tiket kereta ekonomi
     */
    public static Ticket createEconomyTicket(String destination, double price) {
        return new TrainTicket(destination, price, TicketType.ECONOMY);
    }

    /**
     * Membuat tiket kereta bisnis.
     *
     * @param destination tujuan tiket
     * @param price       harga tiket ekonomi
     * @return tiket kereta bisnis
     */
    public static Ticket createBusinessTicket(String destination, double price) {
        double businessPrice = calculateBusinessPrice(price);
        return new TrainTicket(destination, businessPrice, TicketType.BUSINESS);
    }

    private static double calculateBusinessPrice(double price) {
        return price + (price * 0.2); // Menambahkan 20% ke harga tiket ekonomi
    }
}

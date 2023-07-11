package interfaces;

/**
 * Interface untuk objek tiket.
 */
public interface Ticket {
    /**
     * Mengembalikan tujuan dari tiket.
     *
     * @return tujuan tiket.
     */
    String getDestination();

    /**
     * Mengembalikan harga dari tiket.
     *
     * @return harga tiket.
     */
    double getPrice();

    TicketType getType();
}

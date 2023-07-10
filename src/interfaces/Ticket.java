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

    TicketType geType();

    /**
     * Mengembalikan harga dari tiket.
     *
     * @return harga tiket.
     */
    double getPrice();

    TicketType getType();
}

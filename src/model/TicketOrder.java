package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.Ticket;

/**
 * Kelas untuk melakukan pemesanan tiket.
 */
public class TicketOrder {
    private User user;
    private List<Ticket> tickets;

    /**
     * Konstruktor TicketOrder.
     *
     * @param user pengguna yang melakukan pemesanan tiket
     */
    public TicketOrder(User user) {
        this.user = user;
        this.tickets = new ArrayList<>();
    }

    /**
     * Menambahkan tiket ke dalam pemesanan.
     *
     * @param ticket tiket yang akan ditambahkan
     */
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    /**
     * Menghapus tiket dari pemesanan.
     *
     * @param ticket tiket yang akan dihapus
     */
    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    /**
     * Menghitung total harga dari tiket-tiket yang dipesan.
     *
     * @return total harga tiket
     */
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Ticket ticket : tickets) {
            totalPrice += ticket.getPrice();
        }
        return totalPrice;
    }

    /**
     * Melakukan proses checkout untuk pemesanan tiket.
     *
     * @param user pengguna yang melakukan checkout
     */
    public void checkout() {
        if (tickets.isEmpty()) {
            System.out.println("Tidak ada pesanan untuk diperiksa.");
            return;
        }

        System.out.println("=== PEMERIKSAAN PESANAN ===");
        System.out.println("Pesanan Anda saat ini:");
        int i = 1;
        for (Ticket ticket : tickets) {
            System.out.println(i + ". Tujuan: " + ticket.getDestination() + ", Harga: " + ticket.getPrice());
            i++;
        }

        System.out.print("Pilih nomor pesanan yang ingin diperiksa: ");
        Scanner scanner = new Scanner(System.in);
        int checkoutChoice = scanner.nextInt();
        scanner.nextLine(); // Membuang karakter '\n'

        if (checkoutChoice >= 1 && checkoutChoice <= tickets.size()) {
            Ticket ticketToCheckout = tickets.get(checkoutChoice - 1);
            double totalPrice = ticketToCheckout.getPrice();
            double saldo = user.getSaldo();
            if (saldo >= totalPrice) {
                user.setSaldo(saldo - totalPrice);
                System.out.println("Pemesanan tiket berhasil. Saldo Anda: " + user.getSaldo());
                tickets.remove(ticketToCheckout);
                generatePurchaseReceipt(ticketToCheckout, user);
                // Proses pengiriman tiket
            } else {
                System.out.println("Saldo tidak mencukupi. Pemesanan gagal.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    /**
     * Membatalkan pesanan tiket.
     */
    public void cancelOrder() {
        if (tickets.isEmpty()) {
            System.out.println("Tidak ada pesanan untuk dibatalkan.");
            return;
        }

        System.out.println("=== PEMBATALAN PESANAN ===");
        System.out.println("Pesanan Anda saat ini:");
        int i = 1;
        for (Ticket ticket : tickets) {
            System.out.println(i + ". Tujuan: " + ticket.getDestination() + ", Harga: " + ticket.getPrice());
            i++;
        }

        System.out.print("Pilih nomor pesanan yang ingin dibatalkan: ");
        Scanner scanner = new Scanner(System.in);
        int cancelChoice = scanner.nextInt();
        scanner.nextLine(); // Membuang karakter '\n'

        if (cancelChoice >= 1 && cancelChoice <= tickets.size()) {
            Ticket ticketToCancel = tickets.get(cancelChoice - 1);
            tickets.remove(ticketToCancel);
            System.out.println("Pesanan berhasil dibatalkan.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    /**
     * Menghasilkan struk pembelian untuk tiket yang dibeli.
     *
     * @param ticket tiket yang dibeli
     * @param user   pengguna yang melakukan pembelian
     */
    private void generatePurchaseReceipt(Ticket ticket, User user) {
        System.out.println("=== STRUK PEMBELIAN ===");
        System.out.println("Pengguna: " + user.getNama());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Tujuan: " + ticket.getDestination());
        System.out.println("Harga: " + ticket.getPrice());
        System.out.println("Terima kasih, selamat menikmati perjalanan!");
    }

    /**
     * Mengembalikan daftar tiket dalam pemesanan.
     *
     * @return daftar tiket
     */
    public List<Ticket> getTickets() {
        return tickets;
    }
}

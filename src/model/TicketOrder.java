package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.Ticket;

// Kelas untuk melakukan pemesanan tiket
public class TicketOrder {
    private User user;
    private List<Ticket> tickets;

    public TicketOrder(User user) {
        this.user = user;
        this.tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Ticket ticket : tickets) {
            totalPrice += ticket.getPrice();
        }
        return totalPrice;
    }

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
                // Proses pengiriman tiket
            } else {
                System.out.println("Saldo tidak mencukupi. Pemesanan gagal.");
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

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

    public List<Ticket> getTickets() {
        return tickets;
    }
}

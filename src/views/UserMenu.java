package views;

import java.util.Scanner;

import model.Schedule;
import model.Ticket;
import model.TicketOrder;
import model.User;

// Kelas untuk menu pengguna
public class UserMenu {
    private Scanner scanner;
    private User currentUser;
    private TicketOrder ticketOrder;
    private Schedule schedule;

    public UserMenu(User user, Schedule schedule) {
        scanner = new Scanner(System.in);
        currentUser = user;
        ticketOrder = new TicketOrder(currentUser);
        this.schedule = schedule;
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n=== MENU USER ===");
            System.out.println("1. Lihat Jadwal Tiket");
            System.out.println("2. Pesan Tiket");
            System.out.println("3. Batalkan Pesanan");
            System.out.println("4. Checkout");
            System.out.println("5. Lihat Saldo");
            System.out.println("6. Isi Saldo");
            System.out.println("7. Logout");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter '\n'

            if (choice == 1) {
                System.out.println("=== LIHAT JADWAL TIKET ===");
                schedule.displaySchedule();
            } else if (choice == 2) {
                System.out.println("=== PESAN TIKET ===");
                schedule.displaySchedule();
                System.out.print("Pilih nomor jadwal tiket yang ingin dipesan: ");
                int ticketChoice = scanner.nextInt();
                scanner.nextLine(); // Membuang karakter '\n'

                if (ticketChoice >= 1 && ticketChoice <= schedule.getTickets().size()) {
                    Ticket ticket = schedule.getTickets().get(ticketChoice - 1);
                    ticketOrder.addTicket(ticket);
                    System.out.println("Tiket berhasil ditambahkan ke dalam pesanan.\n");
                } else {
                    System.out.println("Pilihan tidak valid.\n");
                }
            } else if (choice == 3) {
                ticketOrder.cancelOrder();
            } else if (choice == 4) {
                System.out.println("=== CHECKOUT ===");
                if (ticketOrder.getTickets().isEmpty()) {
                    System.out.println("Anda belum memiliki tiket dalam pesanan.\n");
                } else {
                    ticketOrder.checkout();
                }
            } else if (choice == 5) {
                System.out.println("Saldo Anda: " + currentUser.getSaldo());
            } else if (choice == 6) {
                System.out.println("=== ISI SALDO ===");
                System.out.print("Masukkan jumlah saldo yang ingin diisi: ");
                double saldo = scanner.nextDouble();
                scanner.nextLine(); // Membuang karakter '\n'

                double currentSaldo = currentUser.getSaldo();
                currentUser.setSaldo(currentSaldo + saldo);
                System.out.println("Saldo berhasil diisi. Saldo Anda sekarang: " + currentUser.getSaldo());
            } else if (choice == 7) {
                // Logout dari akun user
                break;
            } else {
                System.out.println("Pilihan tidak valid.\n");
            }
        }
    }
}

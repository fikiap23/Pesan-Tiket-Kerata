package views;

import java.util.Scanner;

import interfaces.Ticket;
import model.Schedule;
import model.TicketOrder;
import model.User;

/**
 * Kelas untuk tampilan menu pengguna.
 */
public class UserMenu {
    private Scanner scanner;
    private User currentUser;
    private TicketOrder ticketOrder;
    private Schedule schedule;

    /**
     * Konstruktor untuk UserMenu.
     *
     * @param user     objek User yang sedang login.
     * @param schedule objek Schedule untuk jadwal tiket.
     */
    public UserMenu(User user, Schedule schedule) {
        scanner = new Scanner(System.in);
        currentUser = user;
        ticketOrder = new TicketOrder(currentUser);
        this.schedule = schedule;
    }

    /**
     * Menampilkan menu pengguna.
     */
    public void displayMenu() {
        while (true) {
            System.out.println("\n=== MENU USER ===");
            System.out.println("1. Lihat Jadwal Tiket");
            System.out.println("2. Pesan Tiket");
            System.out.println("3. Batalkan Pesanan");
            System.out.println("4. Checkout");
            System.out.println("5. Lihat Saldo");
            System.out.println("6. Isi Saldo");
            System.out.println("7. Info Akun");
            System.out.println("8. Logout");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter '\n'

            if (choice == 1) {
                displaySchedule();
            } else if (choice == 2) {
                orderTicket();
            } else if (choice == 3) {
                cancelOrder();
            } else if (choice == 4) {
                checkout();
            } else if (choice == 5) {
                displaySaldo();
            } else if (choice == 6) {
                isiSaldo();
            } else if (choice == 7) {
                infoAkun();
            } else if (choice == 8) {
                break;
            } else {
                System.out.println("Pilihan tidak valid.\n");
            }
        }
    }

    private void displaySchedule() {
        schedule.displaySchedule();
    }

    private void orderTicket() {
        System.out.println("=== PESAN TIKET ===");
        displaySchedule();
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
    }

    private void cancelOrder() {
        ticketOrder.cancelOrder();
    }

    private void checkout() {
        System.out.println("=== CHECKOUT ===");
        if (ticketOrder.getTickets().isEmpty()) {
            System.out.println("Anda belum memiliki tiket dalam pesanan.\n");
        } else {
            ticketOrder.checkout();
        }
    }

    private void displaySaldo() {
        System.out.println("Saldo Anda: " + currentUser.getSaldo());
    }

    private void isiSaldo() {
        System.out.println("=== ISI SALDO ===");
        System.out.print("Masukkan jumlah saldo yang ingin diisi: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine(); // Membuang karakter '\n'

        double currentSaldo = currentUser.getSaldo();
        currentUser.setSaldo(currentSaldo + saldo);
        System.out.println("Saldo berhasil diisi. Saldo Anda sekarang: " + currentUser.getSaldo());
    }

    private void infoAkun() {
        System.out.println("=== INFORMASI AKUN ===");
        System.out.println("Username: " + currentUser.getUsername());
        System.out.println("Nama: " + currentUser.getNama());
        System.out.println("Saldo: " + currentUser.getSaldo());
        System.out.println("Email: " + currentUser.getEmail());
        System.out.println("Nomor Telepon: " + currentUser.getNomorTelepon());
        System.out.println("Alamat: " + currentUser.getAlamat());
    }

}

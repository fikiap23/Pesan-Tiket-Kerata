package views;

import java.util.Scanner;

import interfaces.Ticket;
import model.Schedule;
import model.TicketFactory;
import model.TrainTicketFactory;

/**
 * Kelas untuk tampilan menu admin.
 */
public class AdminMenu {
    private Scanner scanner;
    private Schedule schedule;

    /**
     * Konstruktor untuk AdminMenu.
     *
     * @param scanner  objek Scanner untuk input pengguna.
     * @param schedule objek Schedule untuk jadwal tiket.
     */
    public AdminMenu(Scanner scanner, Schedule schedule) {
        this.scanner = scanner;
        this.schedule = schedule;
    }

    /**
     * Menampilkan menu admin.
     */
    public void displayMenu() {
        while (true) {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Tambah Jadwal Tiket");
            System.out.println("2. Hapus Jadwal Tiket");
            System.out.println("3. Lihat Jadwal Tiket");
            System.out.println("4. Logout");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter '\n'

            if (choice == 1) {
                addTicket();
            } else if (choice == 2) {
                removeTicket();
            } else if (choice == 3) {
                displaySchedule();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Pilihan tidak valid.\n");
            }
        }
    }

    private void addTicket() {
        System.out.println("=== TAMBAH JADWAL TIKET ===");
        System.out.print("Tujuan: ");
        String destination = scanner.nextLine();
        System.out.print("Harga: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Membuang karakter '\n'

        TicketFactory ticketFactory = new TrainTicketFactory();
        Ticket ticket = ticketFactory.createTicket(destination, price);
        schedule.addTicket(ticket);

        System.out.println("Jadwal tiket berhasil ditambahkan.\n");
    }

    private void removeTicket() {
        System.out.println("=== HAPUS JADWAL TIKET ===");
        displaySchedule();
        System.out.print("Pilih nomor jadwal tiket yang ingin dihapus: ");
        int ticketChoice = scanner.nextInt();
        scanner.nextLine(); // Membuang karakter '\n'

        if (ticketChoice >= 1 && ticketChoice <= schedule.getTickets().size()) {
            Ticket ticketToRemove = schedule.getTickets().get(ticketChoice - 1);
            schedule.removeTicket(ticketToRemove);
            System.out.println("Jadwal tiket berhasil dihapus.\n");
        } else {
            System.out.println("Pilihan tidak valid.\n");
        }
    }

    private void displaySchedule() {
        System.out.println("=== JADWAL DAN HARGA TIKET ===");
        int i = 1;
        for (Ticket ticket : schedule.getTickets()) {
            System.out.println(i + ". Tujuan: " + ticket.getDestination() + ", Harga: " + ticket.getPrice());
            i++;
        }
    }
}

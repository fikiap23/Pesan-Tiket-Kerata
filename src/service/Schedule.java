package service;

import java.util.ArrayList;
import java.util.List;

import interfaces.Ticket;
import interfaces.TicketType;

/**
 * Kelas jadwal tiket.
 */
public class Schedule {
    private List<Ticket> tickets;

    public Schedule() {
        this.tickets = new ArrayList<>();
    }

    /**
     * Mengembalikan daftar tiket.
     *
     * @return daftar tiket.
     */
    public List<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Menambahkan tiket ke jadwal.
     *
     * @param ticket tiket yang akan ditambahkan.
     */
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    /**
     * Menghapus tiket dari jadwal.
     *
     * @param ticket tiket yang akan dihapus.
     */
    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    /**
     * Menampilkan jadwal dan harga tiket.
     */
    public void displaySchedule() {
        System.out.println("=== JADWAL DAN HARGA TIKET ===");
        int i = 1;
        for (Ticket ticket : tickets) {
            String ticketType = (ticket.getType() == TicketType.BUSINESS) ? "Bisnis" : "Ekonomi";
            System.out.println(i + ". Tujuan: " + ticket.getDestination() + ", Tipe: " + ticketType + ", Harga: "
                    + ticket.getPrice());
            i++;
        }
    }
}

/**
 * Single Responsibility Principle (SRP): Kelas Schedule memiliki tanggung jawab
 * tunggal yaitu mengatur jadwal tiket. Kelas ini memiliki metode-metode yang
 * berkaitan dengan manipulasi jadwal tiket seperti menambahkan tiket, menghapus
 * tiket, dan menampilkan jadwal tiket. Hal ini sesuai dengan prinsip SRP yang
 * menyatakan bahwa sebuah kelas harus memiliki satu alasan untuk berubah.
 * 
 * Open/Closed Principle (OCP): Dalam kelas Schedule, tidak ada modifikasi
 * langsung terhadap kode sumber kelas. Kelas ini terbuka untuk perluasan
 * melalui penambahan tiket baru ke jadwal menggunakan metode addTicket(). Ini
 * memungkinkan perubahan dalam jadwal tiket tanpa mempengaruhi implementasi
 * langsung dari kelas Schedule.
 * 
 * Liskov Substitution Principle (LSP): Dalam contoh kode yang diberikan, tidak
 * ada pewarisan atau penggunaan kelas turunan, sehingga LSP tidak berlaku dalam
 * konteks ini.
 * 
 * Interface Segregation Principle (ISP): Kelas Schedule tidak
 * mengimplementasikan antarmuka apa pun, sehingga tidak ada penerapan ISP dalam
 * kelas ini.
 * 
 * Dependency Inversion Principle (DIP): Kelas Schedule menggunakan abstraksi
 * Ticket dan TicketType melalui interfacenya. Hal ini memungkinkan
 * fleksibilitas dalam hal jenis tiket yang dapat ditambahkan ke jadwal tanpa
 * tergantung pada implementasi konkret. Dengan demikian, kelas Schedule
 * mengikuti prinsip DIP.
 */
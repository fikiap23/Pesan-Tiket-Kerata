package service;

import interfaces.Ticket;
import interfaces.TicketType;

/**
 * Enum yang menyimpan tipe tiket kereta.
 */

/**
 * Kelas tiket kereta.
 */
public class TrainTicket implements Ticket {
    private String destination;
    private double price;
    private TicketType type;

    public TrainTicket(String destination, double price, TicketType type) {
        this.destination = destination;
        this.price = price;
        this.type = type;
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

    /**
     * Mengembalikan tipe tiket kereta.
     *
     * @return tipe tiket kereta.
     */
    @Override
    public TicketType getType() {
        return type;
    }

}

/**
 * Single Responsibility Principle (SRP): Kelas TrainTicket memiliki tanggung
 * jawab tunggal yaitu merepresentasikan tiket kereta. Kelas ini hanya memiliki
 * metode-metode yang berkaitan dengan tiket kereta seperti mendapatkan
 * informasi tujuan tiket, harga tiket, dan tipe tiket. Hal ini sesuai dengan
 * prinsip SRP yang menyatakan bahwa sebuah kelas harus memiliki satu alasan
 * untuk berubah.
 * 
 * Open/Closed Principle (OCP): Dalam kelas TrainTicket, tidak ada modifikasi
 * langsung terhadap kode sumber kelas. Kelas ini dapat diperluas dengan
 * penambahan jenis tiket kereta baru dengan tetap mempertahankan implementasi
 * yang ada. Ini memungkinkan perubahan atau penambahan fitur pada tiket kereta
 * tanpa harus memodifikasi implementasi kelas TrainTicket secara langsung.
 * 
 * Liskov Substitution Principle (LSP): Dalam contoh kode yang diberikan, tidak
 * ada pewarisan atau penggunaan kelas turunan, sehingga LSP tidak berlaku dalam
 * konteks ini.
 * 
 * Interface Segregation Principle (ISP): Kelas TrainTicket mengimplementasikan
 * antarmuka Ticket. Antarmuka ini hanya berisi metode-metode yang berkaitan
 * dengan tiket seperti mendapatkan informasi tujuan, harga, dan tipe tiket.
 * Dengan demikian, kelas TrainTicket memisahkan antarmuka ini sesuai dengan
 * kebutuhan dan mematuhi prinsip ISP.
 * 
 * Dependency Inversion Principle (DIP): Kelas TrainTicket bergantung pada
 * abstraksi TicketType melalui antarmukanya. Hal ini memungkinkan fleksibilitas
 * dalam hal tipe tiket yang digunakan, tanpa tergantung pada implementasi
 * konkret. Dengan demikian, kelas TrainTicket mengikuti prinsip DIP.
 */
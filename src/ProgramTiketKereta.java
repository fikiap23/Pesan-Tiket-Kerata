import java.util.Scanner;

import database.UserDatabaseSingleton;
import service.Admin;
import service.Schedule;
import service.User;
import views.AdminMenu;
import views.UserMenu;

public class ProgramTiketKereta {
    private static Scanner scanner = new Scanner(System.in);
    private static UserDatabaseSingleton userDatabase = UserDatabaseSingleton.getInstance();
    private static Schedule schedule = new Schedule();
    private static AdminMenu menuAdmin;
    private static UserMenu menuUser;

    public static void main(String[] args) {
        // Membuat akun dummy untuk admin
        Admin admin = new Admin.Builder("admin", "admin123")
                .setNama("Admin")
                .setEmail("admin@admin.com")
                .build();

        userDatabase.addUser(admin);
        menuAdmin = new AdminMenu(scanner, schedule);

        while (true) {
            System.out.println("=== SISTEM PEMESANAN TIKET KERETA ===");
            System.out.println("1. Daftar");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter '\n'

            if (choice == 1) {
                System.out.println("=== DAFTAR ===");
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                // Mengecek apakah username sudah digunakan
                if (userDatabase.getUser(username) != null) {
                    System.out.println("Username sudah digunakan. Pendaftaran gagal.\n");
                    continue;
                }

                // Membuat user baru menggunakan builder
                User.Builder userBuilder = new User.Builder(username, password);

                System.out.print("Apakah Anda ingin mengisi informasi biodata? (y/n): ");
                String option = scanner.nextLine();
                if (option.equalsIgnoreCase("y")) {
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    userBuilder.setNama(nama);

                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    userBuilder.setEmail(email);

                    System.out.print("Nomor Telepon: ");
                    String nomorTelepon = scanner.nextLine();
                    userBuilder.setNomorTelepon(nomorTelepon);

                    System.out.print("Alamat: ");
                    String alamat = scanner.nextLine();
                    userBuilder.setAlamat(alamat);
                }

                User user = userBuilder.build();

                userDatabase.addUser(user);
                menuUser = new UserMenu(user, schedule);

                System.out.println("Pendaftaran berhasil.\n");
            } else if (choice == 2) {
                System.out.println("=== LOGIN ===");
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                User loggedInUser = userDatabase.getUser(username);

                // Login
                if (loggedInUser != null && loggedInUser.getPassword().equals(password)) {
                    // Jika login berhasil
                    System.out.println("Login berhasil.");

                    if (loggedInUser instanceof Admin) {
                        menuAdmin.displayMenu();
                    } else {
                        menuUser = new UserMenu(loggedInUser, schedule);
                        menuUser.displayMenu();
                    }
                } else {
                    // Jika login gagal
                    System.out.println("Username atau password salah.\n");
                }

            } else if (choice == 3) {
                // Keluar dari program
                break;
            } else {
                System.out.println("Pilihan tidak valid.\n");
            }
        }
    }
}

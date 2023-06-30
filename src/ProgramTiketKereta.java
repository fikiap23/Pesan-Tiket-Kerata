import java.util.Scanner;

import database.UserDatabaseSingleton;
import model.Admin;
import model.Schedule;
import model.User;
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
        Admin admin = new Admin("admin", "admin123");
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

                // Membuat user baru
                User user = new User(username, password);
                userDatabase.addUser(user);
                menuUser = new UserMenu(user, schedule);

                System.out.println("Pendaftaran berhasil.\n");
            } else if (choice == 2) {
                System.out.println("=== LOGIN ===");
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                // Login
                User loggedInUser = userDatabase.getUser(username);
                if (loggedInUser != null && loggedInUser.getPassword().equals(password)) {
                    // Jika login berhasil
                    System.out.println("Login berhasil.");

                    if (loggedInUser instanceof Admin) {
                        menuAdmin.displayMenu();
                    } else {
                        if (menuUser == null) {
                            menuUser = new UserMenu(loggedInUser, schedule);
                        }
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

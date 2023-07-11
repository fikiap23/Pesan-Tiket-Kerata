package database;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import interfaces.UserStorage;
import service.User;

/**
 * Implementasi database pengguna menggunakan Singleton Pattern.
 */
public final class UserDatabaseSingleton implements UserStorage {
    private static volatile UserDatabaseSingleton instance;
    private Map<String, User> users;

    /**
     * Konstruktor private untuk UserDatabaseSingleton.
     */
    private UserDatabaseSingleton() {
        users = new ConcurrentHashMap<>();
    }

    /**
     * Mendapatkan instance tunggal dari UserDatabaseSingleton.
     *
     * @return instance UserDatabaseSingleton
     */
    public static synchronized UserDatabaseSingleton getInstance() {
        if (instance == null) {
            instance = new UserDatabaseSingleton();
        }
        return instance;
    }

    /**
     * Menambahkan pengguna ke database.
     *
     * @param user pengguna yang akan ditambahkan
     */
    @Override
    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    /**
     * Menghapus pengguna dari database.
     *
     * @param user pengguna yang akan dihapus
     */
    @Override
    public void removeUser(User user) {
        users.remove(user.getUsername());
    }

    /**
     * Mendapatkan pengguna berdasarkan username.
     *
     * @param username username pengguna yang akan dicari
     * @return pengguna dengan username yang sesuai atau null jika tidak ditemukan
     */
    @Override
    public User getUser(String username) {
        return users.get(username);
    }

    /**
     * Mendapatkan daftar semua pengguna dalam database.
     *
     * @return daftar semua pengguna
     */
    @Override
    public List<User> getAllUsers() {
        return new CopyOnWriteArrayList<>(users.values());
    }

    /**
     * Mendapatkan detail pengguna berdasarkan username.
     *
     * @param username username pengguna yang akan dicari
     * @return detail pengguna dalam format string atau pesan error jika pengguna
     *         tidak ditemukan
     */

    public String getUserDetails(String username) {
        User user = users.get(username);
        if (user != null) {
            StringBuilder userDetails = new StringBuilder();
            userDetails.append("Username: ").append(user.getUsername()).append("\n");
            userDetails.append("Nama: ").append(user.getNama()).append("\n");
            userDetails.append("Email: ").append(user.getEmail()).append("\n");
            userDetails.append("Nomor Telepon: ").append(user.getNomorTelepon()).append("\n");
            userDetails.append("Alamat: ").append(user.getAlamat()).append("\n");
            userDetails.append("Saldo: ").append(user.getSaldo()).append("\n");
            return userDetails.toString();
        }
        return "User dengan username " + username + " tidak ditemukan.";
    }
}

/**
 * Single Responsibility Principle (SRP): Setiap kelas harus memiliki satu
 * tanggung jawab tunggal, yaitu hanya satu alasan untuk berubah. Dalam kelas
 * UserDatabaseSingleton, tanggung jawabnya adalah menyimpan dan mengelola data
 * pengguna.
 * 
 * Open-Closed Principle (OCP): Kode sumber harus terbuka untuk ekstensi, tetapi
 * tertutup untuk modifikasi. Dalam UserDatabaseSingleton, kelas ini dapat
 * diperluas untuk mengimplementasikan antarmuka atau fitur baru tanpa mengubah
 * kode yang sudah ada.
 * 
 * Liskov Substitution Principle (LSP): Objek dari kelas turunan harus dapat
 * diganti dengan objek kelas induknya tanpa mengganggu kebenaran atau kegunaan
 * program. Dalam konteks UserDatabaseSingleton, prinsip ini tidak terlalu
 * berlaku karena kelas tersebut tidak memiliki pewarisan.
 * 
 * Interface Segregation Principle (ISP): Klien tidak boleh dipaksa bergantung
 * pada antarmuka yang tidak mereka gunakan. Dalam kasus UserDatabaseSingleton,
 * antarmuka UserStorage mengungkapkan semua metode yang dibutuhkan oleh
 * pengguna, sehingga tidak ada pemborosan fungsionalitas yang tidak diperlukan.
 * 
 * Dependency Inversion Principle (DIP): Modul tingkat tinggi tidak boleh
 * bergantung pada modul tingkat rendah, keduanya seharusnya bergantung pada
 * abstraksi. Dalam UserDatabaseSingleton, kelas tidak memiliki ketergantungan
 * langsung pada kelas lain, sehingga tidak ada masalah yang melanggar prinsip
 * ini.
 */
package database;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import model.User;

/**
 * Implementasi database pengguna menggunakan Singleton Pattern.
 */
public final class UserDatabaseSingleton {
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
    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    /**
     * Menghapus pengguna dari database.
     *
     * @param user pengguna yang akan dihapus
     */
    public void removeUser(User user) {
        users.remove(user.getUsername());
    }

    /**
     * Mendapatkan pengguna berdasarkan username.
     *
     * @param username username pengguna yang akan dicari
     * @return pengguna dengan username yang sesuai atau null jika tidak ditemukan
     */
    public User getUser(String username) {
        return users.get(username);
    }

    /**
     * Mendapatkan daftar semua pengguna dalam database.
     *
     * @return daftar semua pengguna
     */
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

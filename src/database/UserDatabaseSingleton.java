package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.User;

/**
 * Implementasi database pengguna menggunakan Singleton Pattern.
 */
public class UserDatabaseSingleton {
    private static UserDatabaseSingleton instance;
    private Map<String, User> users;

    private UserDatabaseSingleton() {
        users = new HashMap<>();
    }

    public static UserDatabaseSingleton getInstance() {
        if (instance == null) {
            instance = new UserDatabaseSingleton();
        }
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public void removeUser(User user) {
        users.remove(user.getUsername());
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

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

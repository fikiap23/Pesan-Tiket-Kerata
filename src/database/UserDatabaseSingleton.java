package database;

import java.util.HashMap;
import java.util.Map;

import interfaces.UserDatabase;
import model.User;

/**
 * Implementasi database pengguna menggunakan Singleton Pattern.
 */
public class UserDatabaseSingleton implements UserDatabase {
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

    @Override
    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public void removeUser(User user) {
        users.remove(user.getUsername());
    }

    @Override
    public User getUser(String username) {
        return users.get(username);
    }
}

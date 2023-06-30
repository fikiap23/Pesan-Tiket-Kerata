package database;

import model.User;

import java.util.*;

// Implementasi database user menggunakan Singleton Pattern
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
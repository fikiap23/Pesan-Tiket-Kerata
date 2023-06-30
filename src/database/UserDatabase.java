package database;

import model.User;

public interface UserDatabase {
    void addUser(User user);

    void removeUser(User user);

    User getUser(String username);
}

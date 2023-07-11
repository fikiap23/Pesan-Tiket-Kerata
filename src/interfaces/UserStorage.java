package interfaces;

import java.util.List;
import service.User;

/**
 * Database pengguna.
 */
public interface UserStorage {
    /**
     * Menambahkan pengguna ke database.
     *
     * @param user pengguna yang akan ditambahkan.
     */
    void addUser(User user);

    /**
     * Menghapus pengguna dari database.
     *
     * @param user pengguna yang akan dihapus.
     */
    void removeUser(User user);

    /**
     * Mendapatkan pengguna berdasarkan nama pengguna.
     *
     * @param username nama pengguna.
     * @return pengguna dengan nama pengguna yang sesuai, atau null jika tidak
     *         ditemukan.
     */
    User getUser(String username);

    List<User> getAllUsers();
}

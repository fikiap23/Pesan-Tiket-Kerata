package model;

/**
 * Kelas User yang merepresentasikan pengguna.
 */
public class User {
    private String username;
    private String password;
    private double saldo;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.saldo = 0.0;
    }

    /**
     * Mengembalikan username pengguna.
     *
     * @return username pengguna.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Mengembalikan password pengguna.
     *
     * @return password pengguna.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Mengembalikan saldo pengguna.
     *
     * @return saldo pengguna.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Mengatur saldo pengguna.
     *
     * @param saldo saldo yang akan diatur.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

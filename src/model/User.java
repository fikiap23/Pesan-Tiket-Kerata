package model;

// Kelas user
public class User {
    private String username;
    private String password;
    private double saldo;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.saldo = 0.0;
    }

    // Getters dan setters

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

package service;

import interfaces.UserDataInterface;
import interfaces.UserInterface;

/**
 * Kelas User yang merepresentasikan pengguna.
 */
public class User implements UserInterface,UserDataInterface{
    private String username;
    private String password;
    private String nama;
    private String email;
    private String nomorTelepon;
    private String alamat;
    private double saldo;

    public User(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.nama = builder.nama;
        this.email = builder.email;
        this.nomorTelepon = builder.nomorTelepon;
        this.alamat = builder.alamat;
        this.saldo = builder.saldo;
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
     * Mengembalikan nama pengguna.
     *
     * @return nama pengguna.
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengembalikan email pengguna.
     *
     * @return email pengguna.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Mengembalikan nomor telepon pengguna.
     *
     * @return nomor telepon pengguna.
     */
    public String getNomorTelepon() {
        return nomorTelepon;
    }

    /**
     * Mengembalikan alamat pengguna.
     *
     * @return alamat pengguna.
     */
    public String getAlamat() {
        return alamat;
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

    /**
     * Builder generik untuk membuat objek User.
     *
     * @param <T> jenis builder yang dihasilkan.
     */
    public static class Builder<T extends Builder<T>> {
        private String username;
        private String password;
        private String nama;
        private String email;
        private String nomorTelepon;
        private String alamat;
        private double saldo;

        public Builder(String username, String password) {
            this.username = username;
            this.password = password;
        }

        /**
         * Mengatur nama pengguna.
         *
         * @param nama nama pengguna.
         * @return builder saat ini.
         */
        public T setNama(String nama) {
            this.nama = nama;
            return self();
        }

        /**
         * Mengatur email pengguna.
         *
         * @param email email pengguna.
         * @return builder saat ini.
         */
        public T setEmail(String email) {
            this.email = email;
            return self();
        }

        /**
         * Mengatur nomor telepon pengguna.
         *
         * @param nomorTelepon nomor telepon pengguna.
         * @return builder saat ini.
         */
        public T setNomorTelepon(String nomorTelepon) {
            this.nomorTelepon = nomorTelepon;
            return self();
        }

        /**
         * Mengatur alamat pengguna.
         *
         * @param alamat alamat pengguna.
         * @return builder saat ini.
         */
        public T setAlamat(String alamat) {
            this.alamat = alamat;
            return self();
        }

        /**
         * Mengatur saldo pengguna.
         *
         * @param saldo saldo pengguna.
         * @return builder saat ini.
         */
        public T setSaldo(double saldo) {
            this.saldo = saldo;
            return self();
        }

        /**
         * Metode abstrak yang mengembalikan instance builder saat ini.
         *
         * @return instance builder saat ini.
         */
        protected T self() {
            return (T) this;
        }

        /**
         * Membangun objek User.
         *
         * @return objek User.
         */
        public User build() {
            return new User(this);
        }
    }
}

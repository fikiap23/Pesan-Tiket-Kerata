package interfaces;

public interface UserDataInterface {

    /**
     * Mengembalikan nama pengguna.
     *
     * @return nama pengguna.
     */
    String getNama();

    /**
     * Mengembalikan email pengguna.
     *
     * @return email pengguna.
     */
    String getEmail();

    /**
     * Mengembalikan nomor telepon pengguna.
     *
     * @return nomor telepon pengguna.
     */
    String getNomorTelepon();

    /**
     * Mengembalikan alamat pengguna.
     *
     * @return alamat pengguna.
     */
    String getAlamat();
}

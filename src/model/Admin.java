package model;

/**
 * Kelas admin yang merupakan turunan dari User.
 */
public class Admin extends User {
    public Admin(Builder builder) {
        super(builder);
    }

    /**
     * Builder untuk membuat objek Admin.
     */
    public static class Builder extends User.Builder<Builder> {
        public Builder(String username, String password) {
            super(username, password);
        }

        /**
         * Membangun objek Admin.
         *
         * @return objek Admin.
         */
        @Override
        public Admin build() {
            return new Admin(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}

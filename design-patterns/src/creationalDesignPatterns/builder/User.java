package creationalDesignPatterns.builder;

public class User {
    private String userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;

    private User() {}

    private User(UserBuilder userBuilder) {
        userId = userBuilder.userId;
        userName = userBuilder.userName;
        password = userBuilder.password;
        firstName = userBuilder.firstName;
        lastName = userBuilder.lastName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class UserBuilder {
        private String userId;
        private String userName;
        private String password;
        private String firstName;
        private String lastName;

        public UserBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

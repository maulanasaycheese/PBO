import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users = new ArrayList<>();

    public UserManager() {
        loadDefaultUsers();
    }

    private void loadDefaultUsers() {
        users.add(new User("admin", "admin123", "Admin Perpustakaan"));
        users.add(new User("faiq", "tesia", "Faiq")); 
    }

    public boolean register(String username, String password, String namaLengkap) {
        if (findUser(username) != null) {
            return false;
        }
        users.add(new User(username, password, namaLengkap));
        return true;
    }

    public User login(String username, String password) {
        User user = findUser(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    private User findUser(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
}
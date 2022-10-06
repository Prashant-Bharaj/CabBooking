package repository;

import model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository implements IRiderRepository {
    private final Map<String, User> userMap;

    public UserRepository() {
        userMap = new HashMap<>();
    }

    @Override
    public void save(User user) {
        userMap.put(user.getName(), user);
    }

    @Override
    public Optional<User> findByName(String name) {
        return Optional.ofNullable(userMap.get(name));
    }
}

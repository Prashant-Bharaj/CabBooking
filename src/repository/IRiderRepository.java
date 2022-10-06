package repository;

import model.User;

import java.util.Optional;

public interface IUserRepository {
    public void save(User user);
    public Optional<User> findByName(String name);
}

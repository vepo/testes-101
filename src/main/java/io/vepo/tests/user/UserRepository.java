package io.vepo.tests.user;

import java.util.List;

public interface UserRepository {
    public List<User> list();

    public User add(User newUser);
}
package io.vepo.tests.user;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepositoryInMemory implements UserRepository {

    private Map<Long, User> database = new HashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @Override
    public List<User> list() {
        return database.values().stream().collect(toList());
    }

    @Override
    public User add(User newUser) {
        newUser.setId(counter.incrementAndGet());
        return newUser;
    }

}

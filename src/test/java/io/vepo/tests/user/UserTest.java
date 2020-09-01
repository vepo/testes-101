package io.vepo.tests.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    @Mock
    private UserRepository userRepository;

    @Spy
    private UserRepositoryInMemory userRepositoryInMemory;

    @Test
    @DisplayName("Testa o exemplo de Mock para UserRepository")
    public void listUserTest() {
        assertThat(userRepository.list()).isEmpty();
    }

    @Test
    @DisplayName("Testa o exemplo de Mock para UserRepository")
    public void addUserInMemoryTest() {

        User userWithoutId = new User();
        userWithoutId.setEmail("vepo@vepo.com");
        userWithoutId.setUsername("vepo");

        assertThat(userRepositoryInMemory.add(userWithoutId)).hasFieldOrPropertyWithValue("id", 1L);

        verify(userRepositoryInMemory).add(userWithoutId);
    }

    @Test
    @DisplayName("Testa o exemplo de Mock para UserRepository")
    public void addUserTest() {
        User userWithoutId = new User();
        userWithoutId.setEmail("vepo@vepo.com");
        userWithoutId.setUsername("vepo");

        User userWithId = new User();
        userWithId.setId(1L);
        userWithId.setEmail("vepo@vepo.com");
        userWithId.setUsername("vepo");

        when(userRepository.add(userWithoutId)).thenReturn(userWithId);

        assertThat(userRepository.add(userWithoutId)).hasFieldOrPropertyWithValue("id", 1L);
    }
}

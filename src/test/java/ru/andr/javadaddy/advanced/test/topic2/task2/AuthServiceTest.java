package ru.andr.javadaddy.advanced.test.topic2.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void authenticateUser_success() {
        User user = new User("username", "password");

        when(userRepository.findUserByUsername("username")).thenReturn(user);

        assertTrue(authService.authenticateUser("username", "password"));

        verify(userRepository, times(1)).findUserByUsername("username");
    }

    @Test
    void authenticateUser_passwordMismatch() {
        User user = new User("username", "password");

        when(userRepository.findUserByUsername("username")).thenReturn(user);

        assertFalse(authService.authenticateUser("username", "passworddd"));

        verify(userRepository, times(1)).findUserByUsername("username");
    }

    @Test
    void authenticateUser_userNotFound() {
        when(userRepository.findUserByUsername("username")).thenReturn(null);

        assertFalse(authService.authenticateUser("username", "password"));

        verify(userRepository, times(1)).findUserByUsername("username");
    }
}

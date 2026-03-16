package com.leo.user_api.service;

import com.leo.user_api.model.User;
import com.leo.user_api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void shouldReturnAllUsers() {

        UserRepository repository = Mockito.mock(UserRepository.class);
        UserService service = new UserService(repository);

        User user = new User("Leo", "leo@email.com");

        Mockito.when(repository.findAll()).thenReturn(List.of(user));

        List<User> users = service.getAllUsers();

        assertEquals(1, users.size());
    }

    @Test
    void shouldReturnCorrectUserName() {

        UserRepository repository = Mockito.mock(UserRepository.class);
        UserService service = new UserService(repository);

        User user = new User("Ana", "ana@email.com");

        Mockito.when(repository.findAll()).thenReturn(List.of(user));

        List<User> users = service.getAllUsers();

        assertEquals("Ana", users.get(0).getName());
    }

    @Test
    void shouldCreateUser() {

        UserRepository repository = Mockito.mock(UserRepository.class);
        UserService service = new UserService(repository);

        User user = new User("Carlos", "carlos@email.com");

        Mockito.when(repository.save(user)).thenReturn(user);

        User savedUser = service.createUser(user);

        assertEquals("Carlos", savedUser.getName());
    }

    @Test
    void shouldReturnCorrectEmail() {

        UserRepository repository = Mockito.mock(UserRepository.class);
        UserService service = new UserService(repository);

        User user = new User("Maria", "maria@email.com");

        Mockito.when(repository.save(user)).thenReturn(user);

        User savedUser = service.createUser(user);

        assertEquals("maria@email.com", savedUser.getEmail());
    }

    @Test
    void shouldReturnEmptyList() {

        UserRepository repository = Mockito.mock(UserRepository.class);
        UserService service = new UserService(repository);

        Mockito.when(repository.findAll()).thenReturn(List.of());

        List<User> users = service.getAllUsers();

        assertTrue(users.isEmpty());
    }
}
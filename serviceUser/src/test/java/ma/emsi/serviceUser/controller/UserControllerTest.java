package ma.emsi.serviceUser.controller;

import ma.emsi.serviceUser.model.User;
import ma.emsi.serviceUser.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @Test
    void findById() {
        User testUser = new User(1, "John", "Doe", "john.doe@example.com", "password");
        when(userRepository.findById(1)).thenReturn(testUser);

        User response = userController.findById("1");  // Correction de ce type

        assertEquals(testUser, response);
    }

    @Test
    void findAll() {
        List<User> testUsers = Arrays.asList(new User(2, "2John", "2Doe", "2john.doe@example.com", "password"), new User(1, "John", "Doe", "john.doe@example.com2", "password2"));
        when(userRepository.findAll()).thenReturn(testUsers);

        List<User> response = userController.findAll();

        assertEquals(testUsers, response);
    }

    @Test
    void save() {
        User testUser = new User(1, "John", "Doe", "john.doe@example.com", "password");
        when(userRepository.save(any())).thenReturn(testUser);

        //Ville savedVille = villeController.save(new Ville());
        userController.save(new User());

        verify(userRepository, times(1)).save(any());
    }

    @Test
    void patch() {// Créer une instance de test de Ville
        // Créer une instance de test de Ville
        User testUser = new User(1, "John", "Doe", "john.doe@example.com", "password");

        // Configurer le comportement du mock pour le save de villeRepository
        when(userRepository.save(any(User.class))).thenReturn(null);

        // Appeler la méthode patch de villeController avec la ville de test
        userController.patch(testUser);

        // Vérifier que la méthode save de villeRepository est appelée une fois avec la ville de test
        verify(userRepository, times(1)).save(eq(testUser));
    }
    @Test
    void delete() {
        User testUser = new User(1, "John", "Doe", "john.doe@example.com", "password");
        when(userRepository.findById(1)).thenReturn(testUser);
        doNothing().when(userRepository).delete(testUser);

        userController.delete("1");

        verify(userRepository, times(1)).delete(testUser);
    }

    @Test
    void deleteAll() {
        doNothing().when(userRepository).deleteAll();

        userController.deleteAll();

        verify(userRepository, times(1)).deleteAll();
    }


    @Test
    void count() {
        when(userRepository.count()).thenReturn(5L);

        long response = userController.count();

        assertEquals(5L, response);
    }

}
package ma.emsi.serviceChambre.controller;

import ma.emsi.serviceChambre.model.Ville;
import ma.emsi.serviceChambre.repository.VilleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class VilleControllerTest {

    @Mock
    private VilleRepository villeRepository;

    @InjectMocks
    private VilleController villeController;

    @Test
    void findById() {
        Ville testVille = new Ville(1, "Test Ville");
        when(villeRepository.findById(1)).thenReturn(testVille);

        Ville response = villeController.findById("1");  // Correction de ce type

        assertEquals(testVille, response);
    }

    @Test
    void findAll() {
        List<Ville> testVilles = Arrays.asList(new Ville(1, "Test Ville 1"), new Ville(2, "Test Ville 2"));
        when(villeRepository.findAll()).thenReturn(testVilles);

        List<Ville> response = villeController.findAll();

        assertEquals(testVilles, response);
    }

    @Test
    void save() {
        Ville testVille = new Ville(1, "Test Ville");
        when(villeRepository.save(any())).thenReturn(testVille);

        //Ville savedVille = villeController.save(new Ville());
        villeController.save(new Ville());

        verify(villeRepository, times(1)).save(any());
    }

    @Test
    void patch() {// Créer une instance de test de Ville
        // Créer une instance de test de Ville
        Ville testVille = new Ville(1, "Test Ville");

        // Configurer le comportement du mock pour le save de villeRepository
        when(villeRepository.save(any(Ville.class))).thenReturn(null);

        // Appeler la méthode patch de villeController avec la ville de test
        villeController.patch(testVille);

        // Vérifier que la méthode save de villeRepository est appelée une fois avec la ville de test
        verify(villeRepository, times(1)).save(eq(testVille));
    }

    @Test
    void delete() {
        Ville testVille = new Ville(1, "Test Ville");
        when(villeRepository.findById(1)).thenReturn(testVille);
        doNothing().when(villeRepository).delete(testVille);

        villeController.delete("1");

        verify(villeRepository, times(1)).delete(testVille);
    }

    @Test
    void deleteAll() {
        doNothing().when(villeRepository).deleteAll();

        villeController.deleteAll();

        verify(villeRepository, times(1)).deleteAll();
    }


    @Test
    void count() {
        when(villeRepository.count()).thenReturn(5L);

        long response = villeController.count();

        assertEquals(5L, response);
    }
}
package ma.emsi.serviceChambre.controller;

import ma.emsi.serviceChambre.model.Chambre;
import ma.emsi.serviceChambre.model.Hotel;
import ma.emsi.serviceChambre.model.Ville;
import ma.emsi.serviceChambre.repository.ChambreRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)

class ChambreControllerTest {
    @Mock
    private ChambreRepository chambreRepository;

    @InjectMocks
    private ChambreController chambreController;

    @Test
    void findById() {
        Chambre testChambre = new Chambre(1, "Test Chambre", true, new Hotel(1, "Test Hotel", "Test Address", new Ville(1, "Test Ville")));
        when(chambreRepository.findById(1)).thenReturn(testChambre);

        Chambre response = chambreController.findById("1");

        assertEquals(testChambre, response);
    }

    @Test
    void findAll() {
        List<Chambre> testChambres = Arrays.asList(
                new Chambre(1, "Test Chambre 1", true, new Hotel(1, "Test Hotel 1", "Test Address 1", new Ville(1, "Test Ville 1"))),
                new Chambre(2, "Test Chambre 2", false, new Hotel(2, "Test Hotel 2", "Test Address 2", new Ville(2, "Test Ville 2")))
        );
        when(chambreRepository.findAll()).thenReturn(testChambres);

        List<Chambre> response = chambreController.findAll();

        assertEquals(testChambres, response);
    }

    @Test
    void save() {
        Chambre testChambre = new Chambre(1, "Test Chambre", true, new Hotel(1, "Test Hotel", "Test Address", new Ville(1, "Test Ville")));
        when(chambreRepository.save(any())).thenReturn(testChambre);

        chambreController.save(new Chambre());

        verify(chambreRepository, times(1)).save(any());
    }

    @Test
    void patch() {
        Chambre testChambre = new Chambre(1, "Test Chambre", true, new Hotel(1, "Test Hotel", "Test Address", new Ville(1, "Test Ville")));
        when(chambreRepository.save(any(Chambre.class))).thenReturn(null);

        chambreController.patch(testChambre);

        verify(chambreRepository, times(1)).save(eq(testChambre));
    }

    @Test
    void delete() {
        Chambre testChambre = new Chambre(1, "Test Chambre", true, new Hotel(1, "Test Hotel", "Test Address", new Ville(1, "Test Ville")));
        when(chambreRepository.findById(1)).thenReturn(testChambre);
        doNothing().when(chambreRepository).delete(testChambre);

        chambreController.delete("1");

        verify(chambreRepository, times(1)).delete(testChambre);
    }

    @Test
    void deleteAll() {
        doNothing().when(chambreRepository).deleteAll();

        chambreController.deleteAll();

        verify(chambreRepository, times(1)).deleteAll();
    }

    @Test
    void count() {
        when(chambreRepository.count()).thenReturn(5L);

        long response = chambreController.count();

        assertEquals(5L, response);
    }
}
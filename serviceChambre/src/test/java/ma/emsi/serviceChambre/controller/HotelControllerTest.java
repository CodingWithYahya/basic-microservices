package ma.emsi.serviceChambre.controller;

import ma.emsi.serviceChambre.model.Ville;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import ma.emsi.serviceChambre.model.Hotel;
import ma.emsi.serviceChambre.repository.HotelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HotelControllerTest {

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private HotelController hotelController;

    @Test
    void findById() {
        Hotel testHotel = new Hotel(1, "Test Hotel", "Test Address", new Ville(1, "Test Ville"));
        when(hotelRepository.findById(1)).thenReturn(testHotel);

        Hotel response = hotelController.findById("1");

        assertEquals(testHotel, response);
    }

    @Test
    void findAll() {
        List<Hotel> testHotels = Arrays.asList(
                new Hotel(1, "Test Hotel 1", "Test Address 1", new Ville(1, "Test Ville 1")),
                new Hotel(2, "Test Hotel 2", "Test Address 2", new Ville(2, "Test Ville 2"))
        );
        when(hotelRepository.findAll()).thenReturn(testHotels);

        List<Hotel> response = hotelController.findAll();

        assertEquals(testHotels, response);
    }

    @Test
    void save() {
        Hotel testHotel = new Hotel(1, "Test Hotel", "Test Address", new Ville(1, "Test Ville"));
        when(hotelRepository.save(any())).thenReturn(testHotel);

        hotelController.save(new Hotel());

        verify(hotelRepository, times(1)).save(any());
    }

    @Test
    void patch() {
        Hotel testHotel = new Hotel(1, "Test Hotel", "Test Address", new Ville(1, "Test Ville"));
        when(hotelRepository.save(any(Hotel.class))).thenReturn(null);

        hotelController.patch(testHotel);

        verify(hotelRepository, times(1)).save(eq(testHotel));
    }

    @Test
    void delete() {
        Hotel testHotel = new Hotel(1, "Test Hotel", "Test Address", new Ville(1, "Test Ville"));
        when(hotelRepository.findById(1)).thenReturn(testHotel);
        doNothing().when(hotelRepository).delete(testHotel);

        hotelController.delete("1");

        verify(hotelRepository, times(1)).delete(testHotel);
    }

    @Test
    void deleteAll() {
        doNothing().when(hotelRepository).deleteAll();

        hotelController.deleteAll();

        verify(hotelRepository, times(1)).deleteAll();
    }

    @Test
    void count() {
        when(hotelRepository.count()).thenReturn(5L);

        long response = hotelController.count();

        assertEquals(5L, response);
    }
}

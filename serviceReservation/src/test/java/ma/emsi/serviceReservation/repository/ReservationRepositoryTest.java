package ma.emsi.serviceReservation.repository;

import ma.emsi.serviceReservation.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ReservationRepositoryTest {
    @Autowired
    private ReservationRepository reservationRepository;


    @Test
    void findById() {
        // Given
        User user = new User(1, "John", "Doe", "john@example.com", "password");
        Ville ville = new Ville(1, "Test Ville");
        Hotel hotel = new Hotel(1, "Test Hotel", "Test Adresse", ville);
        Chambre chambre = new Chambre(1, "Room 101", true, hotel); // Provide a Hotel instance if needed
        Reservation reservation = new Reservation(1, user, 2, chambre, 2); // Updated line
        reservationRepository.save(reservation);

        // When
        Reservation foundReservation = reservationRepository.findById(1);

        // Then
        assertNotNull(foundReservation);
        assertEquals(1, foundReservation.getId());
        assertEquals(reservation.getId(), foundReservation.getId());

    }
}
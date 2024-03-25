package ma.emsi.serviceReservation.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @Test
    public void testGettersAndSetters() {
        User testUser = new User(1, "TestNom", "TestPrenom", "test@example.com", "testpassword");
        Chambre testChambre = new Chambre(1, "Test Label", true, null);

        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.setUser(testUser);
        reservation.setUserId(1);
        reservation.setChambre(testChambre);
        reservation.setChambreId(1);

        assertEquals(1, reservation.getId());
        assertEquals(testUser, reservation.getUser());
        assertEquals(1, reservation.getUserId());
        assertEquals(testChambre, reservation.getChambre());
        assertEquals(1, reservation.getChambreId());
    }

    @Test
    public void testToString() {
        User testUser = new User(1, "TestNom", "TestPrenom", "test@example.com", "testpassword");
        Chambre testChambre = new Chambre(1, "Test Label", true, null);

        Reservation reservation = new Reservation(1, testUser, 1, testChambre, 1);

        String expectedToString = "Reservation [id=1, user=" + testUser + ", userId=1, chambre=" + testChambre + ", chambreId=1]";
        assertEquals(expectedToString, reservation.toString());
    }

    @Test
    public void testNoArgsConstructor() {
        Reservation reservation = new Reservation();
        assertNotNull(reservation);
    }

    @Test
    public void testAllArgsConstructor() {
        User testUser = new User(1, "TestNom", "TestPrenom", "test@example.com", "testpassword");
        Chambre testChambre = new Chambre(1, "Test Label", true, null);

        Reservation reservation = new Reservation(1, testUser, 1, testChambre, 1);

        assertNotNull(reservation);
        assertEquals(1, reservation.getId());
        assertEquals(testUser, reservation.getUser());
        assertEquals(1, reservation.getUserId());
        assertEquals(testChambre, reservation.getChambre());
        assertEquals(1, reservation.getChambreId());
    }

}
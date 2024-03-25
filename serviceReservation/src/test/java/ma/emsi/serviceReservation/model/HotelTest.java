package ma.emsi.serviceReservation.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    public void testGettersAndSetters() {
        Ville ville = new Ville();
        Hotel hotel = new Hotel();

        hotel.setId(1);
        hotel.setNom("Test Hotel");
        hotel.setAdresse("Test Adresse");
        hotel.setVille(ville);

        assertEquals(1, hotel.getId());
        assertEquals("Test Hotel", hotel.getNom());
        assertEquals("Test Adresse", hotel.getAdresse());
        assertEquals(ville, hotel.getVille());
    }

    @Test
    public void testToString() {
        Ville ville = new Ville(1, "Test Ville");
        Hotel hotel = new Hotel(1, "Test Hotel", "Test Adresse", ville);

        String expectedToString = "Hotel [id=1, nom=Test Hotel, adresse=Test Adresse, ville=" + ville + "]";
        assertEquals(expectedToString, hotel.toString());
    }

    @Test
    public void testNoArgsConstructor() {
        Hotel hotel = new Hotel();
        assertNotNull(hotel);
    }

    @Test
    public void testAllArgsConstructor() {
        Ville ville = new Ville(1, "Test Ville");
        Hotel hotel = new Hotel(1, "Test Hotel", "Test Adresse", ville);

        assertNotNull(hotel);
        assertEquals(1, hotel.getId());
        assertEquals("Test Hotel", hotel.getNom());
        assertEquals("Test Adresse", hotel.getAdresse());
        assertEquals(ville, hotel.getVille());
    }

}
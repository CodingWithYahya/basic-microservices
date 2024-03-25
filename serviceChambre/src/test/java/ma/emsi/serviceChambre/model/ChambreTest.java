package ma.emsi.serviceChambre.model;

import org.junit.jupiter.api.Test;	

import static org.junit.jupiter.api.Assertions.*;

class ChambreTest {

    @Test
    public void testGettersAndSetters() {
        Ville ville = null;
        Hotel hotel = new Hotel(1, "Test Hotel", "edgz", ville);
        Chambre chambre = new Chambre();

        chambre.setId(1);
        chambre.setLabel("Test Label");
        chambre.setDispo(true);
        chambre.setHotel(hotel);

        assertEquals(1, chambre.getId());
        assertEquals("Test Label", chambre.getLabel());
        assertTrue(chambre.isDispo());
        assertEquals(hotel, chambre.getHotel());
    }

    @Test
    public void testToString() {
        Ville ville = null;
        Hotel hotel = new Hotel(1, "Test Hotel", "edgz", ville);
        Chambre chambre = new Chambre(1, "Test Label", true, hotel);

        String expectedToString = "Chambre [id=1, label=Test Label, dispo=true, hotel=" + hotel + "]";
        assertEquals(expectedToString, chambre.toString());
    }

    @Test
    public void testNoArgsConstructor() {
        Chambre chambre = new Chambre();
        assertNotNull(chambre);
    }

    @Test
    public void testAllArgsConstructor() {
        Ville ville = null;
        Hotel hotel = new Hotel(1, "Test Hotel", "edgz", ville);
        Chambre chambre = new Chambre(1, "Test Label", true, hotel);

        assertNotNull(chambre);
        assertEquals(1, chambre.getId());
        assertEquals("Test Label", chambre.getLabel());
        assertTrue(chambre.isDispo());
        assertEquals(hotel, chambre.getHotel());
    }

}
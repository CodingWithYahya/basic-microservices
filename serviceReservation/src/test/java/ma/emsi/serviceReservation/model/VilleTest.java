package ma.emsi.serviceReservation.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VilleTest {
    @Test
    public void testGettersAndSetters() {
        Ville ville = new Ville();

        ville.setId(1);
        ville.setLabel("Test Label");

        assertEquals(1, ville.getId());
        assertEquals("Test Label", ville.getLabel());
    }

    @Test
    public void testToString() {
        Ville ville = new Ville(1, "Test Label");

        String expectedToString = "Ville [id=1, label=Test Label]";
        assertEquals(expectedToString, ville.toString());
    }

    @Test
    public void testNoArgsConstructor() {
        Ville ville = new Ville();
        assertNotNull(ville);
    }

    @Test
    public void testAllArgsConstructor() {
        Ville ville = new Ville(1, "Test Label");

        assertNotNull(ville);
        assertEquals(1, ville.getId());
        assertEquals("Test Label", ville.getLabel());
    }
}
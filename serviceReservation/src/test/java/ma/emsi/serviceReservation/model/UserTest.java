package ma.emsi.serviceReservation.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testGettersAndSetters() {
        User user = new User();

        user.setId(1);
        user.setNom("Test Nom");
        user.setPrenom("Test Prenom");
        user.setEmail("test@example.com");
        user.setPassword("testPassword");

        assertEquals(1, user.getId());
        assertEquals("Test Nom", user.getNom());
        assertEquals("Test Prenom", user.getPrenom());
        assertEquals("test@example.com", user.getEmail());
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    public void testToString() {
        User user = new User(1, "Test Nom", "Test Prenom", "test@example.com", "testPassword");

        String expectedToString = "User [id=1, nom=Test Nom, prenom=Test Prenom, email=test@example.com, password=testPassword]";
        assertEquals(expectedToString, user.toString());
    }

    @Test
    public void testNoArgsConstructor() {
        User user = new User();
        assertNotNull(user);
    }

    @Test
    public void testAllArgsConstructor() {
        User user = new User(1, "Test Nom", "Test Prenom", "test@example.com", "testPassword");

        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("Test Nom", user.getNom());
        assertEquals("Test Prenom", user.getPrenom());
        assertEquals("test@example.com", user.getEmail());
        assertEquals("testPassword", user.getPassword());
    }

}
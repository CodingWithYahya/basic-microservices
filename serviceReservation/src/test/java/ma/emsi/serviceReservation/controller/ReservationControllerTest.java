package ma.emsi.serviceReservation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.emsi.serviceReservation.model.Reservation;
import ma.emsi.serviceReservation.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ReservationControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationController reservationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(reservationController).build();
    }

    @Test
    void testFindById() throws Exception {
        Reservation reservation = new Reservation(1, null, 1, null, 1);

        when(reservationRepository.findById(1)).thenReturn(reservation);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/reservation/find/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(asJsonString(reservation)));

        verify(reservationRepository, times(1)).findById(1);
        verifyNoMoreInteractions(reservationRepository);
    }

    @Test
    void testFindAll() throws Exception {
        List<Reservation> reservations = Arrays.asList(
                new Reservation(1, null, 1, null, 1),
                new Reservation(2, null, 2, null, 2)
        );

        when(reservationRepository.findAll()).thenReturn(reservations);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/reservation/findAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(asJsonString(reservations)));

        verify(reservationRepository, times(1)).findAll();
        verifyNoMoreInteractions(reservationRepository);
    }

    @Test
    void testSave() throws Exception {
        Reservation reservation = new Reservation(1, null, 1, null, 1);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/reservation/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(reservation)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(reservationRepository, times(1)).save(reservation);
        verifyNoMoreInteractions(reservationRepository);
    }

    @Test
    void testPatch() throws Exception {
        Reservation reservation = new Reservation(1, null, 1, null, 1);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/reservation/patch")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(reservation)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(reservationRepository, times(1)).save(reservation);
        verifyNoMoreInteractions(reservationRepository);
    }




    @Test
    void testDeleteAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/reservation/deleteAll"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(reservationRepository, times(1)).deleteAll();
        verifyNoMoreInteractions(reservationRepository);
    }

    @Test
    void testCount() throws Exception {
        when(reservationRepository.count()).thenReturn(5L);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/reservation/count"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("5"));

        verify(reservationRepository, times(1)).count();
        verifyNoMoreInteractions(reservationRepository);
    }

    // Helper method to convert objects to JSON string
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
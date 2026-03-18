package co.com.prueba.adapter;

import static org.junit.jupiter.api.Assertions.*;

import co.com.prueba.model.Fondo;
import co.com.prueba.mongo.repositories.FondoRepository;
import mapper.FondoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.*;

class FondoAdapterTest {

    private FondoRepository repository;
    private FondoAdapter adapter;

    @BeforeEach
    void setUp() {
        repository = mock(FondoRepository.class);
        adapter = new FondoAdapter(repository);
    }

    @Test
    void testSaveFondo() {
        Fondo fondo = new Fondo("1", "FPV_BTG", BigDecimal.valueOf(75000), "FPV");

        when(repository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        Fondo saved = adapter.save(fondo);

        assertNotNull(saved);
        assertEquals("FPV_BTG", saved.getNombre());
        verify(repository, times(1)).save(any());
    }

    @Test
    void testFindById() {
        Fondo fondo = new Fondo("1", "FPV_BTG", BigDecimal.valueOf(75000), "FPV");

        when(repository.findById("1")).thenReturn(Optional.of(FondoMapper.toDocument(fondo)));

        Optional<Fondo> result = adapter.findById("1");

        assertTrue(result.isPresent());
        assertEquals("FPV_BTG", result.get().getNombre());
    }
}
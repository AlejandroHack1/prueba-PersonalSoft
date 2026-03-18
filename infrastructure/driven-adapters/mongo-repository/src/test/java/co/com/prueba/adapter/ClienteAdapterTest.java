package co.com.prueba.adapter;

import co.com.prueba.model.Cliente;
import co.com.prueba.mongo.repositories.ClienteRepository;
import mapper.ClienteMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class ClienteAdapterTest {

    private ClienteRepository repository;
    private ClienteAdapter adapter;

    @BeforeEach
    void setUp() {
        repository = mock(ClienteRepository.class);
        adapter = new ClienteAdapter(repository);
    }

    @Test
    void testSaveCliente() {
        Cliente cliente = new Cliente("1", "Juan", "Perez", "juan@mail.com", "3001234567", BigDecimal.valueOf(500000), "EMAIL");

        when(repository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        Cliente saved = adapter.save(cliente);

        assertNotNull(saved);
        assertEquals("Juan", saved.getNombre());
        verify(repository, times(1)).save(any());
    }

    @Test
    void testFindById() {
        Cliente cliente = new Cliente("1", "Juan", "Perez", "juan@mail.com", "3001234567", BigDecimal.valueOf(500000), "EMAIL");

        when(repository.findById("1")).thenReturn(Optional.of(ClienteMapper.toDocument(cliente)));

        Optional<Cliente> result = adapter.findById("1");

        assertTrue(result.isPresent());
        assertEquals("Juan", result.get().getNombre());
    }
}
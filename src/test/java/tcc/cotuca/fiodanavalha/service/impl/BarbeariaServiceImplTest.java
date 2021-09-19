package tcc.cotuca.fiodanavalha.service.impl;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tcc.cotuca.fiodanavalha.repository.BarbeariaRepository;
import tcc.cotuca.fiodanavalha.to.Barbearia;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BarbeariaServiceImplTest {
    private List<Barbearia> barbeariaLista;

    @InjectMocks
    private BarbeariaServiceImpl clienteBarbeariaService;

    @Mock
    private BarbeariaRepository barbeariaRepository;

    @Mock
    private Barbearia clienteBarbearia;


    @BeforeEach
    void configure() {
        this.barbeariaLista = new ArrayList<>();
    }

    @Test
    void quandoBuscarTodasBarbearias_deveRetornarSucesso() {
        when(barbeariaRepository.findAll()).thenReturn(barbeariaLista);
        assertEquals(clienteBarbeariaService.buscarTodasBarbearias(), barbeariaLista);
    }

    @Test
    @SneakyThrows
    void quandoBuscarTodasBarbearias_deveRetornarExcecao() {
        when(barbeariaRepository.findAll()).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> clienteBarbeariaService.buscarTodasBarbearias());
    }

    @Test
    void quandoBuscarBarbeariaPorId_deveRetornarSucesso() {
        when(barbeariaRepository.findById(any())).thenReturn(java.util.Optional.of(clienteBarbearia));
        assertEquals(java.util.Optional.of(clienteBarbearia), clienteBarbeariaService.encontrarPorId(any()));
    }

    @Test
    @SneakyThrows
    void quandoBuscarBarbeariaPorId_deveRetornarExcessao() {
        when(barbeariaRepository.findById(any())).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> clienteBarbeariaService.encontrarPorId(any()));
    }

    @Test
    void quandoInserirUmaBarbearia_deveRetornarSucesso() {
        when(barbeariaRepository.save(clienteBarbearia)).thenReturn(clienteBarbearia);
        assertEquals(clienteBarbearia, clienteBarbeariaService.inserirBarbearia(clienteBarbearia));
    }

    @Test
    void quandoInserirUmaBarbearia_deveRetornarExcecao() {
        when(barbeariaRepository.save(clienteBarbearia)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class,() -> clienteBarbeariaService.inserirBarbearia(clienteBarbearia));
    }

    @Test
    void quandoEditarUmaBarbearia_deveRetornarSucesso() {
        when(barbeariaRepository.save(clienteBarbearia)).thenReturn(clienteBarbearia);
        assertEquals(clienteBarbearia, clienteBarbeariaService.editarBarbearia(clienteBarbearia));
    }

    @Test
    void quandoEditarUmaBarbearia_deveRetornarExcecao() {
        when(barbeariaRepository.save(clienteBarbearia)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class,() -> clienteBarbeariaService.editarBarbearia(clienteBarbearia));
    }

    @Test
    void quandoDeletarUmaBarbearia_deveRetornarSucesso() {
        doNothing().when(barbeariaRepository).deleteById(any());
        clienteBarbeariaService.deletarBarbearia(any());
        verify(barbeariaRepository, times(1)).deleteById(any());
    }
}
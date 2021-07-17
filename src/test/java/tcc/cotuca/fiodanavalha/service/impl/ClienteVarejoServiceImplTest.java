package tcc.cotuca.fiodanavalha.service.impl;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tcc.cotuca.fiodanavalha.repository.ClienteVarejoRepository;
import tcc.cotuca.fiodanavalha.to.ClienteVarejo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class ClienteVarejoServiceImplTest {

    @InjectMocks
    private ClienteVarejoServiceImpl clienteVarejoService;

    @Mock
    private ClienteVarejoRepository clienteVarejoRepository;

    private List<ClienteVarejo> clienteLista;

    @Mock
    private ClienteVarejo clienteVarejo;


    @BeforeEach
    void configure() {
        this.clienteLista = new ArrayList<>();
    }

    @Test
    void quandoBuscarTodosClientes_deveRetornarSucesso() {
        when(clienteVarejoRepository.findAll()).thenReturn(clienteLista);
        assertEquals(clienteVarejoService.buscarTodosCliente(), clienteLista);
    }

    @Test
    @SneakyThrows
    void quandoBuscarTodosClientes_deveRetornarExcecao() {
        when(clienteVarejoRepository.findAll()).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> clienteVarejoService.buscarTodosCliente());
    }

    @Test
    void quandoBuscarClientePorId_deveRetornarSucesso() {
        when(clienteVarejoRepository.findById(any())).thenReturn(java.util.Optional.of(clienteVarejo));
        assertEquals(java.util.Optional.of(clienteVarejo), clienteVarejoService.buscarPorId(any()));
    }

    @Test
    @SneakyThrows
    void quandoBuscarClientePorId_deveRetornarExcessao() {
        when(clienteVarejoRepository.findById(any())).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> clienteVarejoService.buscarPorId(any()));
    }

    @Test
    void quandoInserirUmCliente_deveRetornarSucesso() {
        when(clienteVarejoRepository.insert(clienteVarejo)).thenReturn(clienteVarejo);
        assertEquals(clienteVarejo, clienteVarejoService.inserirCliente(clienteVarejo));
    }

    @Test
    void quandoInserirUmCliente_deveRetornarExcecao() {
        when(clienteVarejoRepository.insert(clienteVarejo)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class,() -> clienteVarejoService.inserirCliente(clienteVarejo));
    }

    @Test
    void quandoEditarUmCliente_deveRetornarSucesso() {
        when(clienteVarejoRepository.save(clienteVarejo)).thenReturn(clienteVarejo);
        assertEquals(clienteVarejo, clienteVarejoService.editarCliente(clienteVarejo));
    }

    @Test
    void quandoEditarUmCliente_deveRetornarExcecao() {
        when(clienteVarejoRepository.save(clienteVarejo)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class,() -> clienteVarejoService.editarCliente(clienteVarejo));
    }

    @Test
    void quandoDeletarUmCliente_deveRetornarSucesso() {
        doNothing().when(clienteVarejoRepository).deleteById(any());
        clienteVarejoService.deletarCliente(any());
        verify(clienteVarejoRepository, times(1)).deleteById(any());
    }
}
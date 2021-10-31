package tcc.cotuca.fiodanavalha.gateway.impl;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tcc.cotuca.fiodanavalha.repository.ClienteRepository;
import tcc.cotuca.fiodanavalha.to.Cliente;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class ClienteGatewayImplTest {

    @InjectMocks
    private ClienteGatewayImpl clienteVarejoService;

    @Mock
    private ClienteRepository clienteRepository;

    private List<Cliente> clienteLista;

    @Mock
    private Cliente clienteVarejo;


    @BeforeEach
    void configure() {
        this.clienteLista = new ArrayList<>();
    }

    @Test
    void quandoBuscarTodosClientes_deveRetornarSucesso() {
        when(clienteRepository.findAll()).thenReturn(clienteLista);
        assertEquals(clienteVarejoService.buscarTodosCliente(), clienteLista);
    }

    @Test
    @SneakyThrows
    void quandoBuscarTodosClientes_deveRetornarExcecao() {
        when(clienteRepository.findAll()).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> clienteVarejoService.buscarTodosCliente());
    }

    @Test
    void quandoBuscarClientePorId_deveRetornarSucesso() {
        when(clienteRepository.findById(any())).thenReturn(java.util.Optional.of(clienteVarejo));
        assertEquals(java.util.Optional.of(clienteVarejo), clienteVarejoService.buscarPorId(any()));
    }

    @Test
    @SneakyThrows
    void quandoBuscarClientePorId_deveRetornarExcessao() {
        when(clienteRepository.findById(any())).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> clienteVarejoService.buscarPorId(any()));
    }

    @Test
    void quandoInserirUmCliente_deveRetornarSucesso() {
        when(clienteRepository.save(clienteVarejo)).thenReturn(clienteVarejo);
        assertEquals(clienteVarejo, clienteVarejoService.inserirCliente(clienteVarejo));
    }

    @Test
    void quandoInserirUmCliente_deveRetornarExcecao() {
        when(clienteRepository.save(clienteVarejo)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class,() -> clienteVarejoService.inserirCliente(clienteVarejo));
    }

    @Test
    void quandoEditarUmCliente_deveRetornarSucesso() {
        when(clienteRepository.save(clienteVarejo)).thenReturn(clienteVarejo);
        assertEquals(clienteVarejo, clienteVarejoService.editarCliente(clienteVarejo));
    }

    @Test
    void quandoEditarUmCliente_deveRetornarExcecao() {
        when(clienteRepository.save(clienteVarejo)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class,() -> clienteVarejoService.editarCliente(clienteVarejo));
    }

    @Test
    void quandoDeletarUmCliente_deveRetornarSucesso() {
        doNothing().when(clienteRepository).deleteById(any());
        clienteVarejoService.deletarCliente(any());
        verify(clienteRepository, times(1)).deleteById(any());
    }
}
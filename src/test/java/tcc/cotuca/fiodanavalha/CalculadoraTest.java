package tcc.cotuca.fiodanavalha;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CalculadoraTest {
    @InjectMocks
    private Calculadora calculadora;

    @Test
    void quandoSomarValoresValidos_deveExecutarComSucesso() {
        assertEquals(8D, calculadora.somar(4D,4D));
    }

    @Test
    @SneakyThrows
    void quandoSomarUmDosValoresInvalidos_deveLancarExcecao() {
        assertThrows(NumberFormatException.class, () -> calculadora.somar(null,4D));
    }

    @Test
    @SneakyThrows
    void quandoSomarTodosValoresInvalidos_deveLancarExcecao() {
        assertThrows(NumberFormatException.class, () -> calculadora.somar(null,null));
    }

    @Test
    void quandoSubtrairValoresValidos_deveExecutarComSucesso() {
        assertEquals(0D, calculadora.subtracao(4D,4D));
    }

    @Test
    @SneakyThrows
    void quandoSubtrairUmDosValoresInvalidos_deveLancarExcecao() {
        assertThrows(NumberFormatException.class, () -> calculadora.subtracao(2D,null));
    }

    @Test
    @SneakyThrows
    void quandoSubtrairTodosValoresInvalidos_deveLancarExcecao() {
        assertThrows(NumberFormatException.class, () -> calculadora.subtracao(null,null));
    }

    @Test
    void quandoDividirValoresValidos_deveExecutarComSucesso() {
        assertEquals(2D, calculadora.divisao(4D,2D));
    }

    @Test
    @SneakyThrows
    void quandoDividirUmDosValoresInvalidos_deveLancarExcecao() {
        assertThrows(NumberFormatException.class, () -> calculadora.divisao(2D,null));
    }

    @Test
    @SneakyThrows
    void quandoDividirTodosValoresInvalidos_deveLancarExcecao() {
        assertThrows(NumberFormatException.class, () -> calculadora.divisao(null,null));
    }

    @Test
    void quandoMultiplicarValoresValidos_deveExecutarComSucesso() {
        assertEquals(8D, calculadora.multiplicacao(4D,2D));
    }

    @Test
    @SneakyThrows
    void quandoMultiplicarUmDosValoresInvalidos_deveLancarExcecao() {
        assertThrows(NumberFormatException.class, () -> calculadora.multiplicacao(1D,null));
    }

    @Test
    @SneakyThrows
    void quandoMultiplicarTodosValoresInvalidos_deveLancarExcecao() {
        assertThrows(NumberFormatException.class, () -> calculadora.multiplicacao(null,null));
    }
}
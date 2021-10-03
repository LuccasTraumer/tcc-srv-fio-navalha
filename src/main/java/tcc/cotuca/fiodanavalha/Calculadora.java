package tcc.cotuca.fiodanavalha;

public class Calculadora {

    public Double somar(final Double primeiroValor, final Double segundoValor) throws NumberFormatException {
        if (primeiroValor != null && segundoValor != null)
            return primeiroValor + segundoValor;

        throw new NumberFormatException("Valores invalidos");
    }

    public Double subtracao(final Double primeiroValor, final Double segundoValor) throws NumberFormatException {
        if (primeiroValor != null && segundoValor != null)
            return primeiroValor - segundoValor;

        throw new NumberFormatException("Valores invalidos");
    }

    public Double multiplicacao(final Double primeiroValor, final Double segundoValor) throws NumberFormatException {
        if (primeiroValor != null && segundoValor != null)
            return primeiroValor * segundoValor;

        throw new NumberFormatException("Valores invalidos");
    }

    public Double divisao(final Double primeiroValor, final Double segundoValor) throws NumberFormatException {
        if (primeiroValor != null && segundoValor != null)
            return primeiroValor / segundoValor;

        throw new NumberFormatException("Valores invalidos");
    }
}

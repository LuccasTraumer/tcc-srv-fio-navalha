package tcc.cotuca.fiodanavalha.exception;

public class FioDaNavalhaException extends RuntimeException {
    public FioDaNavalhaException(String mensagem) { super(mensagem); }

    public FioDaNavalhaException(String mensagem, Throwable throwable) { super(mensagem, throwable);}
}

package tcc.cotuca.fiodanavalha.exception;

public class AutenticacaoException extends RuntimeException {
    public AutenticacaoException(String mensagem) { super(mensagem); }

    public AutenticacaoException(String mensagem, Throwable throwable) { super(mensagem, throwable);}
}
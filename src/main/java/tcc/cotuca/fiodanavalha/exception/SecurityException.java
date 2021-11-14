package tcc.cotuca.fiodanavalha.exception;

public class SecurityException extends RuntimeException {
    public SecurityException(String mensagem) { super(mensagem); }

    public SecurityException(String mensagem, Throwable throwable) { super(mensagem, throwable);}
}

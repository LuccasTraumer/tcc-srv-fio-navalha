package tcc.cotuca.fiodanavalha.exception;

public class CadastroInvalidoException extends RuntimeException {
    public CadastroInvalidoException(String mensagem) { super(mensagem); }

    public CadastroInvalidoException(String mensagem, Throwable throwable) { super(mensagem, throwable);}
}

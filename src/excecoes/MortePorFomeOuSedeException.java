package excecoes;

public class MortePorFomeOuSedeException extends RuntimeException { // Extends RuntimeException
    public MortePorFomeOuSedeException(String mensagem) {
        super(mensagem);
    }
}
package br.com.avaliacao.itau.core.excepiton;

public class RetentativaTransacaoException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public RetentativaTransacaoException(String mensagem) {
		super(mensagem);
	}

}

package br.com.educonnect.negocio.cadastro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CampusNaoExisteExceptionTest {

	@Test
	void testConstrutor() {
		String mensagemEsperada = "Campus não encontrado.";
		CampusNaoExisteException exception = new CampusNaoExisteException(mensagemEsperada);
		assertEquals(mensagemEsperada, exception.getMessage());
	}

	@Test
	void testConstrutorComMensagem() {
		String mensagemEsperada = "O campus X não foi encontrado.";
		CampusNaoExisteException exception = new CampusNaoExisteException("O campus X não foi encontrado.");
		assertEquals(mensagemEsperada, exception.getMessage());
	}

}

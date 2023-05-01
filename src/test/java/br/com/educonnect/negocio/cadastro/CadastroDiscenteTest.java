package br.com.educonnect.negocio.cadastro;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.educonnect.negocio.basica.Discente;
import br.com.educonnect.negocio.fachada.Fachada;

@SpringBootTest
class CadastroDiscenteTest {
	
	/*@Autowired
	private Fachada fachada;

	@Test
	void cadastrarDoisDiscentesComMesmoEmail() {
		Discente d1 = new Discente();
		Discente d2 = new Discente();
		d1.setEmail("lucas@gmail.com");
		d2.setEmail("lucas@gmail.com");
		
		try {
			fachada.salvarDiscente(d1);
			fachada.salvarDiscente(d2);
			fail("Nao pode salvar duas contas com emails iguais.");
		} catch (DiscenteEmailIgualException e) {
			e.printStackTrace();
			assertTrue(true, "Ok");
		}
		
		
	}*/
}

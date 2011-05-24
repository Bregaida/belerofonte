package br.com.belerofonte.funcional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.belerofonte.util.CommonWebSteps;

public class AdminSpec {
	private CommonWebSteps cw;

	@Before
	public void setUp() throws Exception {
		cw = new CommonWebSteps();
	}

	@After
	public void tearDown() throws Exception {
		cw.closeAndQuit();
	}

	@Test
	public void shouldEnterInTheAdminPage() {
		cw.givenImInTheAdminPage();

		cw.checkMessage("Administra��o");
		cw.checkMessage("Plataformas");
		cw.checkMessage("Categorias");
	}
}
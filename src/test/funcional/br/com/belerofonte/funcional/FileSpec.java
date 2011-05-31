package br.com.belerofonte.funcional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.belerofonte.util.CommonWebSteps;

public class FileSpec {
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
	public void shouldEnterInFileUploadPage() {
		cw.login("username", "password");
		cw.checkMessage("Bem vindo, Username!");
		cw.clickTheLink("Adicionar Aplicativo");
		cw.checkMessage("Registre uma aplica��o");
	}
	
	@Test
	public void shouldUploadFile(){
		
		cw.login("username", "password");
		cw.checkMessage("Bem vindo, Username!");
		cw.clickTheLink("Adicionar Aplicativo");
		cw.checkMessage("Registre uma aplica��o");
		cw.checkMessage("Informe os dados do arquivo");		
		cw.typeAtField("Belerofonte", "applicationFile.name");
		cw.typeAtField("Aplica��o do sistema Belerofonte", "applicationFile.description");
		cw.select("selectPlataform","Android");
	}
}
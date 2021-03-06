package funcional.br.com.belerofonte.funcional;

import funcional.br.com.belerofonte.util.CommonWebSteps;
import integration.br.com.belerofonte.dao.DaoTest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import unit.br.com.belerofonte.common.Given;
import br.com.belerofonte.dao.UserDAO;

public class FileSpec {
	private CommonWebSteps cw;
	private Session s;
	private Transaction tx;
	private UserDAO userDao;

	@Before
	public void setUp() throws Exception {
		cw = new CommonWebSteps();
		s = DaoTest.getSession();
		tx = s.beginTransaction();
		userDao = new UserDAO(s);
		userDao.save(Given.user(null, "Username", "username", "username@email.com", "password", "password"));
		tx.commit();
		s.close();
	}

	@After
	public void tearDown() throws Exception {
		cw.closeAndQuit();
		s = DaoTest.getSession();
		tx = s.beginTransaction();
		userDao = new UserDAO(s);
		userDao.remove(userDao.findByUsername("username"));
		tx.commit();
		s.close();
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
		cw.typeAtField("Belerofonte", "file.name");
		cw.typeAtField("Aplica��o do sistema Belerofonte", "file.description");
		cw.select("selectPlataform","Android");
		
		// TODO //cw.clickTheButton("submitFile");
	}
}
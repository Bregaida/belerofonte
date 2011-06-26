package br.com.belerofonte.funcional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.belerofonte.common.Given;
import br.com.belerofonte.dao.DaoTest;
import br.com.belerofonte.dao.UserDAO;
import br.com.belerofonte.util.CommonWebSteps;

public class LoginSpec {
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
		userDao.save(Given.user(null, "Admin", "admin", "admin@email.com", "admin", "admin"));
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
		userDao.remove(userDao.findByUsername("admin"));
		userDao.remove(userDao.findByUsername("username"));
		tx.commit();
		s.close();
	}

	@Test
	public void shouldLoginInAppLikeAdmin() {
		cw.login("admin", "admin");

		cw.checkMessage("Bem vindo, Admin!");
	}

	@Test
	public void shouldLoginInAppLikeNormalUser() {
		cw.login("username", "password");

		cw.checkMessage("Bem vindo, Username!");
	}

	@Test
	public void shouldNotLoginInAppLikeInvalidUser() {
		cw.login("invalid", "invalid");

		cw.checkMessage("Login ou senha inv�lido");
	}
	
	@Test 
	public void shouldLogoffApp(){
		cw.login("username", "password");

		cw.checkMessage("Bem vindo, Username!");
		
		cw.clickTheLink("Logoff");
		
	}
}
package br.com.belerofonte.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.belerofonte.common.Given;
import br.com.belerofonte.components.Account;
import br.com.belerofonte.dao.UserDAO;
import br.com.belerofonte.model.User;
import br.com.caelum.vraptor.util.test.MockResult;

public class UserControllerTest {

	private UserController controller;
	@Mock
	private UserDAO userDAO;
	private MockResult result;
	private Account account;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.result = new MockResult();
		this.account = new Account();
		this.account.performLogin(Given.user(1L, "Name", "marcelocont", "tozzi@gmail.com", "senha", "senha"));
		this.controller = new UserController(userDAO, account, result);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldRegisterAUser() {
		User user = Given.user(1L, "Name", "marcelocontro", "tozzi@gmail.com", "senha", "senha");

		this.controller.create(user);

		Mockito.verify(this.userDAO).save(user);
	}

	@Test
	public void nameShouldBeRegistered() {
		Mockito.when(this.userDAO.findByUsername("registered")).thenReturn(new User());
		Assert.assertTrue(this.controller.verifyUsername("registered"));
	}
	
	@Test
	public void nameShouldNotBeRegistered() {	
		Assert.assertFalse(this.controller.verifyUsername("notregistered"));
	}

	@Test
	public void shouldUpdateUser() {
		User user = Given.user(1L, "Name", "marcelocontro", "tozzi@gmail.com", "senha", "senha");

		this.controller.update(user);

		Mockito.verify(this.userDAO).update(user);
	}

	@Test
	public void shouldDeleteUser() {
		User u = this.userDAO.load(1L);

		this.controller.delete(1L);

		Mockito.verify(this.userDAO).remove(u);
	}
	
	@Test
	public void shouldCallFormMethod(){
		this.controller.form();
	}
	
	@Test
	public void shouldCallShowMethodAndReturnUserInResult(){
		Mockito.when(this.userDAO.load(1L)).thenReturn(new User());

		this.controller.show(1L);
		
		User user = (User) this.result.included().get("person");
		Assert.assertNotNull(user);
	}
	
	@Test
	public void shouldCallEditMethodAndReturnUserInResult(){
		Mockito.when(this.userDAO.load(1L)).thenReturn(new User());

		this.controller.edit(1L);
		
		User type = (User) this.result.included().get("user");
		Assert.assertNotNull(type);
	}
}
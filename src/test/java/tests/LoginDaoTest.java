package tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import modelo.LoginDao;

public class LoginDaoTest {
	
	public LoginDaoTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void teadDownClass() {		
	}
	
	@Before
	public void setUp(){
		
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
    public void testValidCredentials() {
        assertTrue(LoginDao.validarUsuario("sergio.argel", "password"));
    }

    @Test
    public void testInvalidCredentials() {
        assertFalse(LoginDao.validarUsuario("usuarioIncorrecto", "contrasenaIncorrecta"));
    }

    @Test
    public void testEmptyCredentials() {
        assertFalse(LoginDao.validarUsuario("", ""));
    }
}

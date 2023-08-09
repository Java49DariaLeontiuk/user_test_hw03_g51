package telran.user.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.user.model.User;

class UserTest {
	User user;
	String email = "peter@gmail.com";
	String password = "12345Dd!";

	@BeforeEach
	void setUp() throws Exception {
		user = new User(email,password);
	}

	@Test
	void testValidPassword() {
		String validPassword = "Qrwe123!";
		user.setPassword(validPassword);
		assertEquals(validPassword, user.getPassword());
	}
	@Test
	void testPasswordLength() {
		String inValidPassword = "Qrwe12!";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}
	@Test
	void testPassworUpperCase() {
		String inValidPassword = "qrwe123!";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}
	@Test
	void testPasswordLowerCase() {
		String inValidPassword = "QWER123!";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}
	@Test
	void testPasswordDigit() {
		String inValidPassword = "Qrwewer!";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}
	@Test
	void testPasswordSpecialSymbols() {
		String inValidPassword = "Qrwe1234";
		user.setPassword(inValidPassword);
		assertEquals(password, user.getPassword());
	}
	@Test
	void testValidEmail() {
		String validEmail = "ivan@icloud.com";
		user.setEmale(validEmail);
		assertEquals(validEmail, user.getEmale());
	}
	@Test
	void testHaveAtOnEmail() {
		String inValidEmail = "ivanicloud.com";
		user.setEmale(inValidEmail);
		assertEquals(email, user.getEmale());
	}
	@Test
	void testOnlyOneAtOnEmail() {
		String inValidEmail = "ivan@iclou@d.com";
		user.setEmale(inValidEmail);
		assertEquals(email, user.getEmale());
	}
	@Test
	void testHaveDotOnEmail() {
		String inValidEmail = "ivan@icloudcom";
		user.setEmale(inValidEmail);
		assertEquals(email, user.getEmale());
	}
	@Test
	void testHaveMoreThanTwoSymbolsAfterDotOnEmail() {
		String inValidEmail = "ivan@icloudco.m";
		user.setEmale(inValidEmail);
		assertEquals(email, user.getEmale());
	}
	@Test
	void testOnlyAllowedSymbols() {
		String inValidEmail = "iva&n@icloud.com";
		user.setEmale(inValidEmail);
		assertEquals(email, user.getEmale());
	}
}

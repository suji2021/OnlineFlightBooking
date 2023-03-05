package com.flightbooking;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.flightbooking.dao.AdminDaoImpl;
import com.flightbooking.exception.InvalidAdminException;
import com.flightbooking.model.Admin;
import com.flightbooking.repository.AdminRepository;
public class AdminDaoTest {
	@InjectMocks
	private AdminDaoImpl adminDao;
	@Mock
	private AdminRepository adminRepository;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		}
	
	@Test
	public void testRegisterAdmin() {
		Admin admin = new Admin();
		admin.setEmailId("test@test.com");
		admin.setPassword("password");
		when(adminRepository.save(admin)).thenReturn(admin);
		Admin result = adminDao.registerAdmin(admin);
		assertEquals(admin, result);
		}
	
	@Test
	public void testLoginAdmin() throws InvalidAdminException {
		Admin admin = new Admin();
		admin.setEmailId("test@test.com");
		admin.setPassword("password");
		List<Admin> admins = new ArrayList<>();
		admins.add(admin);
		when(adminRepository.validateAdmin("test@test.com", "password")).thenReturn(admins);
		String result = adminDao.loginAdmin(admin);
		assertEquals("Login Successful", result);
		}
	
	@Test(expected = InvalidAdminException.class)
	public void testLoginAdminInvalid() throws InvalidAdminException {
		Admin admin = new Admin();
		admin.setEmailId("test@test.com");
		admin.setPassword("password");
		List<Admin> admins = new ArrayList<>();
		when(adminRepository.validateAdmin("test@test.com", "password")).thenReturn(admins);
		adminDao.loginAdmin(admin);
		}
}
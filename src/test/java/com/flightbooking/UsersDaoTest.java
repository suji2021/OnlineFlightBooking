package com.flightbooking;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.flightbooking.controller.AdminController;
import com.flightbooking.controller.UserController;
import com.flightbooking.dao.UserDaoImpl;
import com.flightbooking.exception.UserNotFoundException;
import com.flightbooking.model.User;


public class UsersDaoTest {
    
	@Mock
    private UserDaoImpl userDao;

 
    @InjectMocks
    private UserController userController;
    
    @InjectMocks
    private AdminController adminController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "Abi", "Ramesh", "abi@example.com", "password",
                null, null, null, 0, null));
        userList.add(new User(2L, "Arun", "Ramesh", "arunramesh@example.com", "password", null, null, null, 0, null));
        when(userDao.getAllUsers()).thenReturn(userList);

        List<User> result = adminController.getAllUsers();
        assertEquals(userList, result);
    }

    @Test
    public void testGetUserById() throws UserNotFoundException {
        User user = new User(1L, "Abi", "Ramesh", "Abiramesh@example.com", "password", null, null, null, 0, null);
        when(userDao.getUserById(1L)).thenReturn(user);

        User result = userController.getUserById(1L);
        assertEquals(user, result);
    }

    @Test
    public void testRegisterUser() {
        User user = new User(0, "Abi", "Ramesh", "abiramesh@example.com", "password", null, null, null, 0, null);
        when(userDao.registerUser(user)).thenReturn(user);

        ResponseEntity<User> result = userController.registerUser(user);
        assertEquals(user, result.getBody());
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    public void testUpdateUser() throws UserNotFoundException {
        User user = new User(0, "Abi", "Ramesh", "abiramesh@example.com", "password",
                null, null, null, 0, null);
        User updatedUser = new User(1L, "Abi", "Ramesh", "abiramesh@example.com", "newpassword", null, null, null, 0, null);
        when(userDao.updateUser(user, 0)).thenReturn(updatedUser);

        User result = userController.updateUser(user, 0);
        assertEquals(updatedUser, result);
    }

    @Test
    public void testDeleteUser() throws UserNotFoundException {
        doNothing().when(userDao).deleteUser(1L);

        ResponseEntity<String> result = userController.deleteUser(1L);
        assertEquals("User Deleted", result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void testLoginUser() throws UserNotFoundException {
        User user = new User();
        when(userDao.loginUser(user)).thenReturn("Success");

        String result = userController.loginUser(user);
        assertEquals("Success", result);
    }
}

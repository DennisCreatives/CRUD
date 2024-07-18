package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        try {
            // Create a new user
             User user = new User("New User", "newuser@email.com");
             userDAO.addUser(user);

            // Read all users
            // List<User> users = userDAO.getAllUsers();
            // for (User user : users){
            // System.out.println(user.getId() + ": " + user.getName() + " - " + user.getEmail());
            // }

            // Read user by Id
            // User user = userDAO.getUserById(7);
            // if (user != null) {
            // System.out.println("User with ID 4: " + user.getName() + " - " + user.getEmail());
            // }

            // Update a user
            // User user = userDAO.getUserById(5);
            // user.setName("D. Muthui");
            // user.setEmail("d.muthui@email.com");
            // userDAO.updateUser(user);

            // Delete a user
            // userDAO.deleteUser(4);
        } catch (DatabaseException e) {
            logger.error("Database Operation Failed", e);
        }
    }
}
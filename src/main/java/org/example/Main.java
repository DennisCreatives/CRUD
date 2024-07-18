package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Create a new user
         // User user = new User("Sarah Doe", "sarah@email.com");
        // userDAO.addUser(user);

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
    }
}
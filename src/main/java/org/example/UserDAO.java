package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    // a method for creating a new user
    public void addUser(User user) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
            logger.info("User added: {}", user);
        } catch (SQLException e) {
            logger.error("Error adding user: {}", user, e);
            throw new DatabaseException("Error adding user", e);
        }
    }

    // a method to get all the users from the db
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
                users.add(user);
            }
            logger.info("Fetched all users");
        } catch (SQLException e) {
            logger.error("Error fetching users: {}", e);
            throw new DatabaseException("Error fetching users", e);
        }
        return users;
    }

    // a method to find a single user by their id
    public User getUserById(int id) {
        User user = null;
        String sql = "SELECT * FROM users WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }
            logger.info("Fetched user with ID: {}", id);
        } catch (SQLException e){
            logger.error("Fetched user with ID: {}", id, e);
            throw new DatabaseException("Error fetching user", e);
        }
        return user;
    }

    // a method to update a user
    public void updateUser(User user) {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();
            logger.info("User updated: {}", user);
        } catch (SQLException e) {
            logger.error("Error updating user: {}", user, e);
            throw new DatabaseException("Error updating user", e);
        }
    }

    // a method to delete a user by id
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            logger.info("User deleted with ID: {}", id);
        } catch (SQLException e) {
            logger.error("Error deleting user with id: {}", id, e);
            throw new DatabaseException("Error deleting user", e);
        }
    }
}

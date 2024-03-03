package com.sajith.udurawana.CRUDDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sajith.udurawana.CRUDDemo.entity.User;

/**
 * Repository interface for managing User entities.
 * Extends JpaRepository to inherit basic CRUD operations.
 * Provides a method to find a user by email.
 * 
 * @param email The email address of the user to search for.
 * @return An Optional containing the user with the specified email, if found.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}

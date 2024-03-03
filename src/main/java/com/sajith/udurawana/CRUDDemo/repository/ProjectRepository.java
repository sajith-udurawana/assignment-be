package com.sajith.udurawana.CRUDDemo.repository;

import com.sajith.udurawana.CRUDDemo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Project entities.
 * Extends JpaRepository to inherit basic CRUD operations.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

}

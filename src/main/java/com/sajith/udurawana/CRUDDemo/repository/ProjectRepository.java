package com.sajith.udurawana.CRUDDemo.repository;

import com.sajith.udurawana.CRUDDemo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}

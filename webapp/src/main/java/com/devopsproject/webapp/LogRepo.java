package com.devopsproject.webapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


 // A Spring Data JPA repository interface for managing Log entities, it provides basic CRUD operations for the Log entity.
@Repository
public interface LogRepo extends JpaRepository<Log, Long> {
}

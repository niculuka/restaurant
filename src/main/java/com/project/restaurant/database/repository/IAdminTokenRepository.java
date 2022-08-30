package com.project.restaurant.database.repository;

import com.project.restaurant.database.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminTokenRepository extends JpaRepository<Token, Long> {



}

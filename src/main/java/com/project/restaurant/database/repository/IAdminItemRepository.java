package com.project.restaurant.database.repository;

import com.project.restaurant.database.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminItemRepository extends JpaRepository<Item, Long>  {



}

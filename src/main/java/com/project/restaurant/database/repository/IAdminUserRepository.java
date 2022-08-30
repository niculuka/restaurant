package com.project.restaurant.database.repository;

import com.project.restaurant.database.model.Role;
import com.project.restaurant.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAdminUserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("update User set role = :role where username = :username")
    void updateUserRole(
            @Param("username") String username,
            @Param("role") Role role
    );

    @Modifying
    @Query("update User set enabled = :enabled where user_id = :id")
    void updateEnabled(@Param("id") Long id, @Param("enabled") Boolean enabled);

}

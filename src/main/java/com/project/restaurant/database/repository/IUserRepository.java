package com.project.restaurant.database.repository;

import com.project.restaurant.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Modifying
    @Query("update User set password = :password where username = :username")
    void updatePassword(
            @Param("username") String username,
            @Param("password") String newPassword
    );

    @Modifying
    @Query("update User set name = :name, email = :email, phone = :phone, address = :address where username = :username")
    void updateUser(
            @Param("username") String username,
            @Param("name") String name,
            @Param("email") String email,
            @Param("phone") String phone,
            @Param("address") String address
    );

    @Modifying
    @Query("update User set enabled = true where user_id = :id")
    void updateEnabled(@Param("id") Long id);

}

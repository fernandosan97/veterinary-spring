package com.veterinary.veterinary.repositories;

import com.veterinary.veterinary.models.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    @Query(value = "{call SP_Login(:username)}", nativeQuery = true)
    UserModel login(@Param("username") String username);
}

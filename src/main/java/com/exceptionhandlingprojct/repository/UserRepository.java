package com.exceptionhandlingprojct.repository;

import com.exceptionhandlingprojct.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

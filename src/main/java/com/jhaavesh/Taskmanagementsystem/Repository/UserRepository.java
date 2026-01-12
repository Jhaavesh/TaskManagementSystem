package com.jhaavesh.Taskmanagementsystem.Repository;

import com.jhaavesh.Taskmanagementsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

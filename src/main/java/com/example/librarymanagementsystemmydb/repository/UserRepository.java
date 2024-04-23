package com.example.librarymanagementsystemmydb.repository;

import com.example.librarymanagementsystemmydb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

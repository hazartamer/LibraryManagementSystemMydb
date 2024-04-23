package com.example.librarymanagementsystemmydb.repository;

import com.example.librarymanagementsystemmydb.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

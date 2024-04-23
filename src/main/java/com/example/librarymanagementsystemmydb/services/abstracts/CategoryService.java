package com.example.librarymanagementsystemmydb.services.abstracts;

import com.example.librarymanagementsystemmydb.entities.Category;

public interface CategoryService {
    Category findById(int id);
}

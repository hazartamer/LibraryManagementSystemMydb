package com.example.librarymanagementsystemmydb.services.concretes;

import com.example.librarymanagementsystemmydb.entities.Category;
import com.example.librarymanagementsystemmydb.repository.CategoryRepository;
import com.example.librarymanagementsystemmydb.services.abstracts.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Bu id'ye ait bir kategori bulunmamaktadır."));
    }
}

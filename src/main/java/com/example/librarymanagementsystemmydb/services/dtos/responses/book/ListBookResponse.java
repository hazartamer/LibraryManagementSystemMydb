package com.example.librarymanagementsystemmydb.services.dtos.responses.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListBookResponse {
    private int id;
    private String name;
    private String authorName;
    private String categoryName;
}

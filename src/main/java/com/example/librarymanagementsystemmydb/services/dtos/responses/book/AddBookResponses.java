package com.example.librarymanagementsystemmydb.services.dtos.responses.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBookResponses {
    private int id;
    private String name;
    private String authorName;
    private String categoryName;
}

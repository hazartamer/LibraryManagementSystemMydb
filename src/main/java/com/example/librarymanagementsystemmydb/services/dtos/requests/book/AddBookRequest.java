package com.example.librarymanagementsystemmydb.services.dtos.requests.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBookRequest {
    @NotBlank
    @Size(min = 3,message = "2 harften az kitap ismi olamaz")
    private String name;

    private String authorName;

    //private boolean isBorrowed;

    private int categoryId;
}

package com.example.librarymanagementsystemmydb.services.dtos.responses.borrow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListBorrowResponse {

    private String status;
    private int bookId;
    private int userId;
}

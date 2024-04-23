package com.example.librarymanagementsystemmydb.services.dtos.responses.borrow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReturnBorrowResponse {
    private int id;
    private int userId;
    private int bookId;
}

package com.example.librarymanagementsystemmydb.services.dtos.requests.borrow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBorrowRequest {
    // private LocalDate delivery_date;
    private int userId;
    private int bookId;

}

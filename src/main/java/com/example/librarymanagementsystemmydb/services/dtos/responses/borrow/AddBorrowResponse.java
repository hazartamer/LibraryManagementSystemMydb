package com.example.librarymanagementsystemmydb.services.dtos.responses.borrow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBorrowResponse {
    private String userName;
    private String userAddress;
    private String userEmail;
    private String userPhoneNumber;
    private String bookName;
    private String bookAuthorName;
    private String bookCategoryName;
}

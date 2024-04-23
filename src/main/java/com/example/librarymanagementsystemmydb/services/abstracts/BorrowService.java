package com.example.librarymanagementsystemmydb.services.abstracts;

import com.example.librarymanagementsystemmydb.entities.Book;
import com.example.librarymanagementsystemmydb.entities.Borrow;
import com.example.librarymanagementsystemmydb.entities.User;
import com.example.librarymanagementsystemmydb.services.dtos.requests.borrow.AddBorrowRequest;
import com.example.librarymanagementsystemmydb.services.dtos.requests.borrow.ReturnBorrowRequest;
import com.example.librarymanagementsystemmydb.services.dtos.responses.borrow.AddBorrowResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.borrow.ReturnBorrowResponse;

public interface BorrowService {

    AddBorrowResponse add(AddBorrowRequest request);
    ReturnBorrowResponse returnBook(ReturnBorrowRequest request);
}

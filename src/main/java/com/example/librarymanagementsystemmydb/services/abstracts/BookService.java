package com.example.librarymanagementsystemmydb.services.abstracts;

import com.example.librarymanagementsystemmydb.entities.Book;
import com.example.librarymanagementsystemmydb.services.dtos.requests.book.AddBookRequest;
import com.example.librarymanagementsystemmydb.services.dtos.requests.book.UpdateBookRequest;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.AddBookResponses;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.DeleteBookResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.ListBookResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.UpdateBookResponse;

import java.util.List;

public interface BookService {
    AddBookResponses add(AddBookRequest request);
    List<ListBookResponse> getAll();
    UpdateBookResponse update(UpdateBookRequest request);
    DeleteBookResponse delete(int id);

    Book findById(int id);
    Book findByIsBorrowed (boolean isBorrowed);

   /* Book borrowBook(int bookId, int userId);

    Book returnBook(int bookId);*/

}

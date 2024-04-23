package com.example.librarymanagementsystemmydb.controller;

import com.example.librarymanagementsystemmydb.services.dtos.requests.book.AddBookRequest;
import com.example.librarymanagementsystemmydb.services.dtos.requests.book.UpdateBookRequest;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.AddBookResponses;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.DeleteBookResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.ListBookResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.UpdateBookResponse;
import com.example.librarymanagementsystemmydb.services.abstracts.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BooksController {
    BookService bookService;

    @PostMapping
    public AddBookResponses add(@RequestBody @Valid AddBookRequest request){
        return bookService.add(request);
    }
    @GetMapping
    public List<ListBookResponse> getAll(){
        return bookService.getAll();
    }
    @PutMapping
    public UpdateBookResponse update(@RequestBody @Valid UpdateBookRequest request){
        return bookService.update(request);
    }
    @DeleteMapping
    public DeleteBookResponse delete(@RequestParam int id){
       return bookService.delete(id);
    }

    /*@PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<Book> borrowBook(@PathVariable int bookId, @PathVariable int userId) {
        Book borrowedBook = bookService.borrowBook(bookId, userId);
        if (borrowedBook != null) {
            return ResponseEntity.ok(borrowedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable int bookId) {
        Book returnedBook = bookService.returnBook(bookId);
        if (returnedBook != null) {
            return ResponseEntity.ok(returnedBook);
        } else {
            return ResponseEntity.badRequest().build(); // or a more descriptive error response
        }
    }*/

}

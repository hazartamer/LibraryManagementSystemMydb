package com.example.librarymanagementsystemmydb.controller;

import com.example.librarymanagementsystemmydb.services.abstracts.BorrowService;
import com.example.librarymanagementsystemmydb.services.dtos.requests.borrow.AddBorrowRequest;
import com.example.librarymanagementsystemmydb.services.dtos.requests.borrow.ReturnBorrowRequest;
import com.example.librarymanagementsystemmydb.services.dtos.requests.user.AddUserRequest;
import com.example.librarymanagementsystemmydb.services.dtos.responses.borrow.AddBorrowResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.borrow.ReturnBorrowResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrows")
@AllArgsConstructor
public class BorrowController {
    BorrowService borrowService;

    @PostMapping
    public AddBorrowResponse add(@RequestBody AddBorrowRequest request){
        return borrowService.add(request);
    }

    @PutMapping("/borrow/{borrowId}")
    public ReturnBorrowResponse returnBook(@RequestBody ReturnBorrowRequest request){
        return borrowService.returnBook(request);
    }
}

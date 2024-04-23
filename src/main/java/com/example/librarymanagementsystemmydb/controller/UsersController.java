package com.example.librarymanagementsystemmydb.controller;

import com.example.librarymanagementsystemmydb.services.dtos.requests.user.AddUserRequest;
import com.example.librarymanagementsystemmydb.services.dtos.responses.user.AddUserResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.user.ListUserResponse;
import com.example.librarymanagementsystemmydb.services.abstracts.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {
    private UserService userService;

    @GetMapping
    public List<ListUserResponse> getAll() {
        return userService.getAll();
    }
    @PostMapping
    public AddUserResponse add(@RequestBody AddUserRequest request){
        return userService.add(request);
    }
}

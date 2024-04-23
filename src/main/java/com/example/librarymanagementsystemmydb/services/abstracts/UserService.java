package com.example.librarymanagementsystemmydb.services.abstracts;

import com.example.librarymanagementsystemmydb.entities.User;
import com.example.librarymanagementsystemmydb.services.dtos.requests.user.AddUserRequest;
import com.example.librarymanagementsystemmydb.services.dtos.responses.user.AddUserResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.user.ListUserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<ListUserResponse> getAll();
    AddUserResponse add(AddUserRequest request);

    User findById(int id);
}

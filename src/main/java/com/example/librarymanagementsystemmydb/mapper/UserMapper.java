package com.example.librarymanagementsystemmydb.mapper;

import com.example.librarymanagementsystemmydb.services.dtos.requests.user.AddUserRequest;
import com.example.librarymanagementsystemmydb.services.dtos.responses.user.AddUserResponse;
import com.example.librarymanagementsystemmydb.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User addFromUserRequest(AddUserRequest request);

    AddUserResponse addFromUserResponse(User user);
}

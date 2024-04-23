package com.example.librarymanagementsystemmydb.services.concretes;

import com.example.librarymanagementsystemmydb.services.dtos.requests.user.AddUserRequest;
import com.example.librarymanagementsystemmydb.services.dtos.responses.user.AddUserResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.user.ListUserResponse;
import com.example.librarymanagementsystemmydb.entities.User;
import com.example.librarymanagementsystemmydb.mapper.UserMapper;
import com.example.librarymanagementsystemmydb.repository.UserRepository;
import com.example.librarymanagementsystemmydb.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;


    @Override
    public List<ListUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(u -> new ListUserResponse(u.getName())).toList();
    }

    @Override
    public AddUserResponse add(AddUserRequest request) {
        User user = UserMapper.INSTANCE.addFromUserRequest(request);
        user = userRepository.save(user);
        AddUserResponse userResponse = UserMapper.INSTANCE.addFromUserResponse(user);
        return userResponse;
    }

    @Override
    public User findById(int id) {
       return userRepository.findById(id).orElseThrow(() -> new RuntimeException("böyle bir kullanıcı bulunmamaktadır"));
    }
}

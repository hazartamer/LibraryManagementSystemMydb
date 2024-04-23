package com.example.librarymanagementsystemmydb.mapper;

import com.example.librarymanagementsystemmydb.entities.Borrow;
import com.example.librarymanagementsystemmydb.services.dtos.requests.borrow.AddBorrowRequest;
import com.example.librarymanagementsystemmydb.services.dtos.requests.borrow.ReturnBorrowRequest;
import com.example.librarymanagementsystemmydb.services.dtos.responses.borrow.AddBorrowResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.borrow.ListBorrowResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.borrow.ReturnBorrowResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BorrowMapper {
    BorrowMapper INSTANCE = Mappers.getMapper(BorrowMapper.class);

    Borrow borrowFromAddRequest(AddBorrowRequest request);


    @Mapping(target = "userName",source = "user.name")
    @Mapping(target = "userAddress",source = "user.address")
    @Mapping(target = "userEmail",source = "user.email")
    @Mapping(target = "userPhoneNumber",source = "user.phoneNumber")
    @Mapping(target = "bookName",source = "book.name")
    @Mapping(target = "bookAuthorName",source = "book.authorName")
    //@Mapping(target = "bookCategoryName",source = "category.name")
    AddBorrowResponse borrowFromAddResponse(Borrow borrow);



    @Mapping(source = "borrowId", target = "id")
    //@Mapping(source = "bookId", target = "book.id")
    //@Mapping(source = "userId", target = "user.id")
    Borrow borrowFromReturnRequest(ReturnBorrowRequest request);

    ReturnBorrowResponse borrowFromReturnResponse(Borrow borrow);
    @Mapping(target = "status", source = "borrow.status")
    @Mapping(target = "bookId", source = "book.id")
    @Mapping(target = "userId", source = "user.id")
    ListBorrowResponse borrowFromListResponse(Borrow borrow);
}

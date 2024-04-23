package com.example.librarymanagementsystemmydb.mapper;

import com.example.librarymanagementsystemmydb.services.dtos.requests.book.AddBookRequest;
import com.example.librarymanagementsystemmydb.services.dtos.requests.book.UpdateBookRequest;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.AddBookResponses;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.DeleteBookResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.ListBookResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.UpdateBookResponse;
import com.example.librarymanagementsystemmydb.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);



    Book bookFromRequest(AddBookRequest request);//addrequest mapping işlemi
    //
    @Mapping(target = "categoryName",source = "category.name")
    AddBookResponses addResponseFromBook(Book book);//addresponse mapping işlemi

    //DELETE İŞLEMLERİ
    DeleteBookResponse deleteResponseFromBook(Book book);
    //DELETE İŞLEMLERİ

    //UPDATE İŞLEMLERİ
    Book updateRequestFromBook(UpdateBookRequest request);
    UpdateBookResponse updateResponseFromBook(Book book);

    //LİST İŞLEMLERİ

    List<ListBookResponse> listResponseFromBook(List<Book> book);
}

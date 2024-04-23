package com.example.librarymanagementsystemmydb.services.concretes;

import com.example.librarymanagementsystemmydb.core.utils.exception.BusinessException;
import com.example.librarymanagementsystemmydb.entities.Category;
import com.example.librarymanagementsystemmydb.services.abstracts.CategoryService;
import com.example.librarymanagementsystemmydb.services.dtos.requests.book.AddBookRequest;
import com.example.librarymanagementsystemmydb.services.dtos.requests.book.UpdateBookRequest;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.AddBookResponses;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.DeleteBookResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.ListBookResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.book.UpdateBookResponse;
import com.example.librarymanagementsystemmydb.entities.Book;
import com.example.librarymanagementsystemmydb.mapper.BookMapper;
import com.example.librarymanagementsystemmydb.repository.BookRepository;
import com.example.librarymanagementsystemmydb.services.abstracts.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    BookRepository bookRepository;
    CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
    }

    @Override
    public AddBookResponses add(AddBookRequest request) {
        Category category = categoryService.findById(request.getCategoryId());
        Book book = BookMapper.INSTANCE.bookFromRequest(request);
        book.setCategory(category);
        bookRepository.save(book);
        AddBookResponses addBookResponses = BookMapper.INSTANCE.addResponseFromBook(book);

    return addBookResponses;
    }

    @Override
    public List<ListBookResponse> getAll() {
        List<Book> book = bookRepository.findAll();
        List<ListBookResponse> bookResponses = BookMapper.INSTANCE.listResponseFromBook(book);
        return bookResponses;
    }

    @Override
    public UpdateBookResponse update(UpdateBookRequest request) {
        Book book = BookMapper.INSTANCE.updateRequestFromBook(request);
        book = bookRepository.save(book);
        UpdateBookResponse addBookResponses = BookMapper.INSTANCE.updateResponseFromBook(book);
        return addBookResponses;
    }

    @Override
    public DeleteBookResponse delete(int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("böyle bir id bulunmamaktadır."));
        bookRepository.delete(book);
        DeleteBookResponse deleteBookResponse = BookMapper.INSTANCE.deleteResponseFromBook(book);
        return deleteBookResponse;
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("böyle bir kitap bulunmamaktadır"));
    }

    @Override
    public Book findByIsBorrowed(boolean isBorrowed) {
      return bookRepository.findByIsBorrowed(isBorrowed).orElseThrow(() -> new RuntimeException("bu kitap zaten ödünç alınmış"));
    }


    private void sameWithNoExit(String name){
        Optional<Book> bookOptional = bookRepository.findByName(name);
        if(bookOptional.isPresent()){
            throw new BusinessException("Aynı isimde kitap bulunduramazsın");
        }
    }
}

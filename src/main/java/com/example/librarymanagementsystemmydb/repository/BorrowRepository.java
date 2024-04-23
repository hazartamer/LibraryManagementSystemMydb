package com.example.librarymanagementsystemmydb.repository;

import com.example.librarymanagementsystemmydb.entities.Borrow;
import com.example.librarymanagementsystemmydb.services.dtos.responses.borrow.ListBorrowResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow,Integer> {

    @Query(value = "Select new com.example.librarymanagementsystemmydb.services.dtos.responses.borrow.ListBorrowResponse"+
    "(b.status,b.book,b.user) from Borrow b Where b.status LIKE concat('%', :query ,'%') ",nativeQuery = false)
    List<ListBorrowResponse> searchByStatus(String query);
}

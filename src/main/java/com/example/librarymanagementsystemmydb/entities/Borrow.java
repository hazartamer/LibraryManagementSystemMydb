package com.example.librarymanagementsystemmydb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Table(name = "borrows")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "issue_date")
    private LocalDate deliveryDate;

    private LocalDate returnDate;

    private LocalDate receiptDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String status = "borrowed";

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    /*
    @OneToOne()
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;


 */
}

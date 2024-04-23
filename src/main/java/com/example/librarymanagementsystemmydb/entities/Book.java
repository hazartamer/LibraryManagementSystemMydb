package com.example.librarymanagementsystemmydb.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank
    @Size(min = 3)
    private String name;
    private String authorName;

    private boolean isBorrowed=false;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
/*
    @OneToOne
    @Transient
    private Borrow borrow;


 */
    @OneToMany(mappedBy = "book")
    private List<Borrow> borrowList;

}

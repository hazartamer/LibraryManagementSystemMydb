package com.example.librarymanagementsystemmydb.services.concretes;

import com.example.librarymanagementsystemmydb.core.utils.exception.BusinessException;
import com.example.librarymanagementsystemmydb.entities.Book;
import com.example.librarymanagementsystemmydb.entities.Borrow;
import com.example.librarymanagementsystemmydb.entities.User;
import com.example.librarymanagementsystemmydb.mapper.BorrowMapper;
import com.example.librarymanagementsystemmydb.repository.BorrowRepository;
import com.example.librarymanagementsystemmydb.services.abstracts.BookService;
import com.example.librarymanagementsystemmydb.services.abstracts.BorrowService;
import com.example.librarymanagementsystemmydb.services.abstracts.UserService;
import com.example.librarymanagementsystemmydb.services.dtos.requests.borrow.AddBorrowRequest;
import com.example.librarymanagementsystemmydb.services.dtos.requests.borrow.ReturnBorrowRequest;
import com.example.librarymanagementsystemmydb.services.dtos.responses.borrow.AddBorrowResponse;
import com.example.librarymanagementsystemmydb.services.dtos.responses.borrow.ReturnBorrowResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BorrowServiceImpl implements BorrowService {
    BorrowRepository borrowRepository;
    UserService userService;
    BookService bookService;
    @Override
    public AddBorrowResponse add(AddBorrowRequest request) {
        User user = userService.findById(request.getUserId());
        Book book = bookService.findById(request.getBookId());
        bookIsBorrowed(book.isBorrowed());
        book.setBorrowed(true);
        Borrow borrow = BorrowMapper.INSTANCE.borrowFromAddRequest(request);
        borrow.setUser(user);
        borrow.setBook(book);
        borrow.setReceiptDate(LocalDate.now());
        LocalDate baslangicTarihi = LocalDate.now();
        LocalDate sontarih = baslangicTarihi.plusDays(10);
        borrow.setReturnDate(sontarih);
        borrow = borrowRepository.save(borrow);
        AddBorrowResponse borrowAddResponse = BorrowMapper.INSTANCE.borrowFromAddResponse(borrow);
        return borrowAddResponse;

    }

    @Override
    public ReturnBorrowResponse returnBook(ReturnBorrowRequest request) {
        Borrow borrow1 = borrowRepository.findById(request.getBorrowId()).orElseThrow(() -> new RuntimeException("böyle bir id yok"));
        Borrow borrow = BorrowMapper.INSTANCE.borrowFromReturnRequest(request);
        LocalDate getReceipDate = borrow1.getReceiptDate();
        LocalDate getReturnDate = borrow1.getReturnDate();
        borrow.setBook(borrow1.getBook());
        borrow.setUser(borrow1.getUser());
        borrow.setReturnDate(getReturnDate);
        borrow.setReceiptDate(getReceipDate);
        borrow.setDeliveryDate(LocalDate.now());
        borrow.setStatus("returned");
        borrow.getBook().setBorrowed(false);
        int a = returnedLate(getReturnDate,LocalDate.now());
        borrow.getUser().setLateFee(a*5);
        borrow = borrowRepository.save(borrow);
        ReturnBorrowResponse returnBorrowResponse = BorrowMapper.INSTANCE.borrowFromReturnResponse(borrow);
        return returnBorrowResponse;

    }
    public int daysBetween (LocalDate startDate, LocalDate endDate){
        int a = (int)ChronoUnit.DAYS.between(startDate, endDate);
        return a;
    }
    public int returnedLate(LocalDate startDate, LocalDate endDate){
        if(startDate.isBefore(endDate)){
            return daysBetween(startDate,endDate);
        }
        return 0;
    }

    public void bookIsBorrowed(boolean isborrow){
        if(isborrow)throw new BusinessException("kitap ödünç alınmış durumda");
    }


}

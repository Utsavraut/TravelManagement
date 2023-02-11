package com.system.travelmanagement.service.impl;
import com.system.travelmanagement.Entity.Book;
import com.system.travelmanagement.Pojo.BookPojo;
import com.system.travelmanagement.Repo.BookRepo;
import com.system.travelmanagement.Repo.DestinationRepo;
import com.system.travelmanagement.Repo.UserRepo;
import com.system.travelmanagement.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class   BookingImpl implements BookService {
private final DestinationRepo destinationRepo;
private final UserRepo userRepo;
private final BookRepo bookRepo;



    @Override
    public String save(BookPojo bookPojo) {
        Book book=new Book();
        book.setCheckin(book.getCheckin());
        book.setCheckout(book.getCheckout());
        book.setPeople(book.getPeople());
        book.setUserId(userRepo.findById(bookPojo.getUserId()).orElseThrow());
        book.setDestId(destinationRepo.findById(bookPojo.getRoomId()).orElseThrow());
        bookRepo.save(book);
        return "Created";
    }
}

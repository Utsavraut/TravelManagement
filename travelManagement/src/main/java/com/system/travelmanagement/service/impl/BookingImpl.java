package com.system.travelmanagement.service.impl;
import com.system.travelmanagement.Entity.Book;
import com.system.travelmanagement.Pojo.BookPojo;
import com.system.travelmanagement.Repo.BookRepo;
import com.system.travelmanagement.Repo.DestinationRepo;
import com.system.travelmanagement.Repo.UserRepo;
import com.system.travelmanagement.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class   BookingImpl implements BookService {
private final DestinationRepo destinationRepo;
private final UserRepo userRepo;
private final BookRepo bookRepo;



    @Override
    public String save(BookPojo bookPojo) {
        Book book=new Book();
        book.setCheckin(bookPojo.getCheckin());
        book.setCheckout(bookPojo.getCheckout());
        book.setPeople(bookPojo.getPeople());
        book.setUserId(userRepo.findById(bookPojo.getUserId()).orElseThrow());
        book.setDestId(destinationRepo.findById(bookPojo.getRoomId()).orElseThrow());
        bookRepo.save(book);
        return "Created";
    }

    @Override
    public List<Book> fetchAll() {
        return this.bookRepo.findAll();
    }

    @Override
    public void deletebyid(Integer id) {
        bookRepo.deleteById(id);
    }
}

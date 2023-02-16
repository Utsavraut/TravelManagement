package com.system.travelmanagement.service;
import com.system.travelmanagement.Entity.Book;
import com.system.travelmanagement.Pojo.BookPojo;
import java.util.List;

public interface BookService {
    String save (BookPojo bookPojo);
    List<Book> fetchAll();
    void deletebyid(Integer id);

    List findBookingById(Integer id);

    Book fetchById(Integer id);
}

package com.system.travelmanagement.Controller;
import com.system.travelmanagement.Entity.Destination;
import com.system.travelmanagement.Pojo.BookPojo;
import com.system.travelmanagement.Pojo.DestinationPojo;
import com.system.travelmanagement.service.Adddestination;
import com.system.travelmanagement.service.BookService;
import com.system.travelmanagement.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookingController {
    private final Adddestination adddestination;
    private final UserService userService;

    private final BookService bookService;
    @GetMapping("/books/{id}")
    public String GetBook(@PathVariable Integer id, Model model, Principal principal){
        Destination desttt=adddestination.fetchById(id);
        model.addAttribute("dest",new DestinationPojo(desttt));
        model.addAttribute("bookingss" ,new BookPojo());
        model.addAttribute("userlog",userService.findByEmail(principal.getName()));
        return "/booki";
    }
    @PostMapping("/savebook")
    public String bookDesti(@Valid BookPojo bookingPojo) {
        bookService.save(bookingPojo);
        return "destination";
    }
}

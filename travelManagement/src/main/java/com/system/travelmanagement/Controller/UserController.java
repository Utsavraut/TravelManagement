package com.system.travelmanagement.Controller;

import com.system.travelmanagement.Entity.User;
import com.system.travelmanagement.Pojo.UserPojo;
import com.system.travelmanagement.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new UserPojo());
        return "registration";
    }

    @PostMapping("/save")
    public String SaveUser(@Valid UserPojo userPojo){
        userService.saveUser(userPojo);
        return "login";
    }

    @GetMapping("/index")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/userss")
    public String GetRevs(Model model) {
        List<User> users = userService.fetchAll();
        model.addAttribute("userlist", users);
        return "users";
    }
    @GetMapping("/delete/{id}")
    public String DelUser(@PathVariable("id")Integer id){
        userService.deletebyid(id);

        return "redirect:/user/userss";
    }
    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }
}
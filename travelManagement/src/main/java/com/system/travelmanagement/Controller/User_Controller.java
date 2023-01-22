package com.system.travelmanagement.Controller;

import com.system.travelmanagement.Entity.User;
import com.system.travelmanagement.Pojo.UserPojo;
import com.system.travelmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class User_Controller {
    private final UserService userService;
    @GetMapping("/register")
    public String getPage(){
        return "register";
    }

    @GetMapping("/list")
    public String getUserist(Model model){
        List<User> users =userService.fetchAll();
        model.addAttribute("userlist",users);
        return "user/index";
    }

    @GetMapping("/create")
    public String createUser(Model model
    ){
        model.addAttribute("user",new UserPojo());
        return "user/create";
    }

    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userPojo){
            userService.saveUser(userPojo);
        return "redirect:/user/list";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model){
        User user = userService.fetchById(id);
        model.addAttribute("user", new UserPojo(user));
        return "user/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return "redirect:/user/list";
    }
}

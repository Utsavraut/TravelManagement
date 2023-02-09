package com.system.travelmanagement.Controller;

import com.system.travelmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class DestinationController {
    private final UserService userService;
    @GetMapping("/add")
    public String addPage(){
        return "adddestination";
    }
}

package com.system.travelmanagement.Controller;

import com.system.travelmanagement.Entity.Destination;
import com.system.travelmanagement.Pojo.DestinationPojo;
import com.system.travelmanagement.service.Adddestination;
import com.system.travelmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dest")

public class DestinationController {
    private final Adddestination adddestination;
    @GetMapping("/add")
    public String addPage(Model model){
        model.addAttribute("desti",new DestinationPojo());
        return "add";
    }
    @GetMapping("/gal")
    public String gallery(){
        return "gallery";
    }
    @PostMapping("/saveDest")
    public String saveDest(DestinationPojo destinationPojo, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:/add";
        }
        adddestination.saveDestination(destinationPojo);
        redirectAttributes.addFlashAttribute("successMsg", "User saved successfully");
        return "redirect:/dest/add";
    }
    public Map<String, String> validateRequest(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return null;
        }
        Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return errors;
    }

    @GetMapping("/dest")
    public String GetDesti(Model model){
        List<Destination> rooms = adddestination.fetchAll();
        model.addAttribute("desti", rooms);
        return  "destination";
    }

    @GetMapping("/destlist")
    public String GetDestiList(Model model){
        List<Destination> destinations = adddestination.fetchAll();
        model.addAttribute("destis", destinations);
        return  "destinationlist";
    }

    @GetMapping("/delete/{id}")
    public String DelUser(@PathVariable("id")Integer id){
        adddestination.deletebyid(id);
        return "redirect:/dest/destlist";
    }
    @GetMapping("/edit/{id}")
    public String editDest(@PathVariable("id") Integer id, Model model){
        Destination destination = adddestination.fetchById(id);
        model.addAttribute("clickeddest", new DestinationPojo(destination));
        return "redirect:/dest/destlist";
    }
    @GetMapping("/products/{id}")
    public String getDestProgile(@PathVariable("id") Integer id, Model model ){
        Destination destination = adddestination.fetchById(id);
        model.addAttribute("destinations", new DestinationPojo(destination));
        model.addAttribute("clickeddest", destination);
        return "edit";
    }
}

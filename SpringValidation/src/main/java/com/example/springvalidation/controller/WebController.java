package com.example.springvalidation.controller;

import com.example.springvalidation.dto.UserDto;
import com.example.springvalidation.model.PersonForm;
import com.example.springvalidation.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequiredArgsConstructor
public class WebController implements WebMvcConfigurer {

    private final UserService userService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }

    @GetMapping("/registration")
    public String registerForm(UserDto userDto){
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@Valid UserDto userDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "register";
        }

        userService.save(userDto);

        return "redirect:/results";
    }

}

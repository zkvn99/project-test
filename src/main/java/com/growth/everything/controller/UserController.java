package com.growth.everything.controller;

import com.growth.everything.dto.user.UserDto;
import com.growth.everything.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/login")
    public String loginForm() {
        return "/user/login";
    }

    @GetMapping("/user/signup")
    public String signupForm() {
        return "/user/signup";
    }

    @PostMapping("/user/signup")
    public String signup(@ModelAttribute UserDto userDto) {
        userService.signup(userDto);
        return "redirect:/";
    }

}

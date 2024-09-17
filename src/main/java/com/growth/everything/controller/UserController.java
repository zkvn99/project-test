package com.growth.everything.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/user/login")
    public String loginForm() {
        return "/user/login";
    }

    @GetMapping("/user/signup")
    public String saveForm() {
        return "/user/signup";
    }

}

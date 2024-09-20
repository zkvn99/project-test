package com.growth.everything.controller;

import com.growth.everything.dto.user.UserDTO;
import com.growth.everything.service.user.UserService;
import jakarta.servlet.http.HttpSession;
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

    @PostMapping("/user/login")
    public String login(@ModelAttribute UserDTO userDTO, HttpSession session) {
        UserDTO user = userService.login(userDTO);
        if (user != null) {
            session.setAttribute("id", user.getId());
            session.setAttribute("email", user.getUserEmail());
            return "redirect:/";
        } else {
            return "/user/login";
        }
    }

    @GetMapping("/user/signup")
    public String signupForm() {
        return "/user/signup";
    }

    @PostMapping("/user/signup")
    public String signup(@ModelAttribute UserDTO userDTO) {
        userService.signup(userDTO);
        return "redirect:/";
    }

}

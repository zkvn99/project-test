package com.growth.everything.controller;

import com.growth.everything.dto.user.UserSessionDTO;
import com.growth.everything.dto.user.UserSignupDTO;
import com.growth.everything.dto.user.UserLoginDTO;
import com.growth.everything.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/login")
    public String loginForm() {
        return "/user/login";
    }

    @PostMapping("/user/login")
    public String login(
                        @RequestParam("userEmail") String userEmail,
                        @RequestParam("userPassword") String userPassword,
                        HttpSession session
    ) {
        UserLoginDTO userLoginDTO = new UserLoginDTO(userEmail, userPassword);
        UserSessionDTO user = userService.login(userLoginDTO);
        if (user != null) {
            session.setAttribute("email", user.getUserEmail());
            session.setAttribute("name", user.getUserEmail());
            return "redirect:/";
        } else {
            return "/user/login";
        }
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/user/signup")
    public String signupForm() {
        return "/user/signup";
    }

    @PostMapping("/user/signup")
    public String signup(
                         @RequestParam("userName") String userName,
                         @RequestParam("userNickname") String userNickname,
                         @RequestParam("userPhone") String userPhone,
                         @RequestParam("userAddress") String userAddress,
                         @RequestParam("userEmail")String userEmail,
                         @RequestParam("userPassword") String userPassword
    ) {
        UserSignupDTO userSignupDTO = new UserSignupDTO(userName, userNickname, userPhone, userAddress, userEmail, userPassword);
        System.out.println(userSignupDTO);
        userService.signup(userSignupDTO);
        return "redirect:/";
    }

}

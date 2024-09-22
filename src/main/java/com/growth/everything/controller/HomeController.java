package com.growth.everything.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                        @RequestParam(value = "perPage", required = false, defaultValue = "10") int perPage,
                        @RequestParam(value = "perPagination", required = false, defaultValue = "5") int perPagination,
                        @RequestParam(value = "type", required = false, defaultValue = "n") String type,
                        @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                        HttpSession session,
                        Model model) {
        String email = (String) session.getAttribute("email");
        if (email != null) {
            model.addAttribute("isLoggedIn", true); // 로그인 상태
        } else {
            model.addAttribute("isLoggedIn", false); // 로그아웃 상태
        }
        return "index";
    }
}

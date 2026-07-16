package com.saonnet.ludo.userprofile.controller;

import com.saonnet.ludo.userprofile.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

// document why we specified base path at class level instead of putting it in methods
@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @GetMapping("/sign-up")
    public String signUp(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "sign-up";
    }
}

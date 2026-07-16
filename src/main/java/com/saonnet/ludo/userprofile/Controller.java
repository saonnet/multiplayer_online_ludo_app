package com.saonnet.ludo.userprofile;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String health() {
        return "<h2>Home page</h2>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h2>Hello admin!</h2>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h2>Hello user</h2>";
    }
}

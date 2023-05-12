package com.facturacion.facturacion.Controllers.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password) {
        if (username.equals("admin") && password.equals("password")) {
            return "principal";
        } else {
            return "redirect:/login?error";
        }
    }

    @GetMapping
    public String loginPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Nombre de usuario o contraseña incorrectos.");
        }
        return "index";
    }
    
}

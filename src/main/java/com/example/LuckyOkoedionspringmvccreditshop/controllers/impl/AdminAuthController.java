package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.controllers.IAuthMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.controllers.ILoginMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.entities.AdminEntity;
import com.example.LuckyOkoedionspringmvccreditshop.services.IAdminService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminAuthController implements IAuthMvcController<AdminEntity> {

    private IAdminService adminService;

    public AdminAuthController(AdminService theAdminService) {
        super();
        this.adminService = theAdminService;
    }

    @GetMapping("")
    public String homePage(Model model) {
        return "redirect:/shop";
    }

    @PostMapping("/register-admin")
    @Override
    public String register( @ModelAttribute("admin") AdminEntity admin) {
        adminService.create(admin);
        return "redirect:/admin-login";
    }

    @GetMapping("/register-admin")
    @Override
    public String theRegisterForm(Model model) {
        model.addAttribute("admin", new AdminEntity());
        return "register_admin";
    }

    @PostMapping("/admin-login")
    @Override
    public String login(@ModelAttribute("admin") AdminEntity admin) {

        return "redirect:/admin";
    }

    @GetMapping("/admin-login")
    @Override
    public String theLoginForm(Model model) {
        return "login_admin";
    }
}

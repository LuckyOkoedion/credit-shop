package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.controllers.ILoginMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.services.IAdminService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminLoginController implements ILoginMvcController {

    private IAdminService<A> adminService;

    public AdminLoginController(AdminService theAdminService) {
        super();
        this.adminService = theAdminService;
    }

    @PostMapping("/admin-login")
    @Override
    public <AdminEntity> String login(@ModelAttribute("admin-user") AdminEntity modelAttribute) {
        return "redirect:/admin";
    }

    @GetMapping("/admin-login")
    @Override
    public String theLoginForm(Model model) {
        return "login_admin";
    }
}

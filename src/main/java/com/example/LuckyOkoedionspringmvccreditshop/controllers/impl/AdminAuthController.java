package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.SecurityService;
import com.example.LuckyOkoedionspringmvccreditshop.ISecurityService;
import com.example.LuckyOkoedionspringmvccreditshop.controllers.IAuthMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.entities.AdminEntity;
import com.example.LuckyOkoedionspringmvccreditshop.pojo.LoginDto;
import com.example.LuckyOkoedionspringmvccreditshop.services.IAdminService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminAuthController implements IAuthMvcController<AdminEntity> {

//    private AuthenticationManager authenticationManager;

    private IAdminService adminService;
    private ISecurityService adminSecurityService;

    public AdminAuthController(AdminService theAdminService, SecurityService theSecurityService
//                               AuthenticationManager theAuthenticationManager
    ) {
        super();
        this.adminService = theAdminService;
        this.adminSecurityService = theSecurityService;
//        this.authenticationManager = theAuthenticationManager;
    }

    @GetMapping("")
    public String homePage(Model model) {
        return "redirect:/shop";
    }

    @PostMapping("/register-admin")
    @Override
    public String register(@ModelAttribute("admin") AdminEntity admin) {
        adminService.create(admin);
        return "redirect:/admin-login";
    }

    @GetMapping("/register-admin")
    @Override
    public String theRegisterForm(Model model) {
        if (adminSecurityService.isAuthenticated()) {
            return "redirect:/admin/dashboard";
        }
        model.addAttribute("admin", new AdminEntity());
        return "register_admin";
    }

    @PostMapping("/admin-login")
    public String login(@ModelAttribute("loginDto") LoginDto loginDto) {
      this.adminSecurityService.login(loginDto.getEmail(), loginDto.getPassword());
        return "redirect:/admin/dashboard";

    }


    @GetMapping("/admin-login")
    @Override
    public String theLoginForm(Model model) {
//        if (adminSecurityService.isAuthenticated()) {
//            return "redirect:/admin/dashboard";
//        }
        model.addAttribute("loginDto", new LoginDto());
        return "login_admin";
    }

    // @PostMapping("/admin-logout")
    // @Override
    // public String logout(AdminEntity modelAttribute) {
    // return "redirect:/admin-login";
    // }


}

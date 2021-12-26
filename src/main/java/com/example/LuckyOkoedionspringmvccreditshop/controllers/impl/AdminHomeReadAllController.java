package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.controllers.IReadAllMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.services.IAdminService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomeReadAllController implements IReadAllMvcController {

    private IAdminService<A> adminService;

    public AdminHomeReadAllController(AdminService theAdminService) {
        super();
        this.adminService = theAdminService;
    }

    @GetMapping("/admin")
    @Override
    public String getAll(Model model) {
        return "admin_home";
    }
}

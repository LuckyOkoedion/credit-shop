package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.AdminSecurityService;
import com.example.LuckyOkoedionspringmvccreditshop.ISecurityService;
import com.example.LuckyOkoedionspringmvccreditshop.controllers.ICrudMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.controllers.IReadAllMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.services.IPurchaseService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.PurchaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminPurchasesReadAllController implements IReadAllMvcController {

    private IPurchaseService purchaseService;
    private ISecurityService adminSecurityService;

    public AdminPurchasesReadAllController(PurchaseService thePurchaseService, AdminSecurityService theAdminSecurityService) {
        super();
        this.purchaseService = thePurchaseService;
        this.adminSecurityService = theAdminSecurityService;
    }

    @GetMapping("/admin-purchases")
    @Override
    public String getAll(Model model) {
        if(adminSecurityService.isAuthenticated()) {
            model.addAttribute("purchases", purchaseService.getAll());
            return "admin_purchases";
        }
        return "redirect:/admin-login";

    }

}

package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.AdminSecurityService;
import com.example.LuckyOkoedionspringmvccreditshop.ISecurityService;
import com.example.LuckyOkoedionspringmvccreditshop.controllers.IReadAllMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.entities.AdminEntity;
import com.example.LuckyOkoedionspringmvccreditshop.services.IAdminService;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICustomerService;
import com.example.LuckyOkoedionspringmvccreditshop.services.IProductService;
import com.example.LuckyOkoedionspringmvccreditshop.services.IPurchaseService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.AdminService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.CustomerService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.ProductService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.PurchaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomeReadAllController implements IReadAllMvcController {

    private IAdminService adminService;
    private IProductService productService;
    private IPurchaseService purchaseService;
    private ICustomerService customerService;
    private ISecurityService adminSecurityService;

    public AdminHomeReadAllController(AdminService theAdminService, ProductService productService,
            PurchaseService purchaseService, CustomerService customerService,
            AdminSecurityService theAdminSecurityService) {
        super();
        this.adminService = theAdminService;
        this.productService = productService;
        this.purchaseService = purchaseService;
        this.customerService = customerService;
        this.adminSecurityService = theAdminSecurityService;
    }

    @GetMapping("/admin")
    @Override
    public String getAll(Model model) {
        if (adminSecurityService.isAuthenticated()) {
            model.addAttribute("admin", adminService.getAll());
            model.addAttribute("products", productService.getAll());
            model.addAttribute("purchases", purchaseService.getAll());
            model.addAttribute("customers", customerService.getAll());
            return "admin_home";
        }

        return "redirect:/admin-login";

    }
}

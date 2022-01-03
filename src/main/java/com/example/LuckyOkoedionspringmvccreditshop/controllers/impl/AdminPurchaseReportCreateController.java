package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.AdminSecurityService;
import com.example.LuckyOkoedionspringmvccreditshop.ISecurityService;
import com.example.LuckyOkoedionspringmvccreditshop.controllers.ICreateMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.entities.PurchaseEntity;
import com.example.LuckyOkoedionspringmvccreditshop.pojo.GeneratePurchaseReportDto;
import com.example.LuckyOkoedionspringmvccreditshop.services.IPurchaseReportService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.PurchaseReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminPurchaseReportCreateController {

    private IPurchaseReportService purchaseReportService;
    private ISecurityService adminSecurityService;

    public AdminPurchaseReportCreateController(PurchaseReportService thePurchaseReportService, AdminSecurityService theAdminSecurityService) {
        super();
        this.purchaseReportService = thePurchaseReportService;
        this.adminSecurityService = theAdminSecurityService;
    }

    @PostMapping("/generate-purchase-report")
    public String create(@ModelAttribute("dto") GeneratePurchaseReportDto dto, Model model) {
        model.addAttribute("report", purchaseReportService.generatePurchaseReport(dto.getStart_date(), dto.getEnd_date()));
        return "admin_purchase_report";
    }

    @GetMapping("/generate-purchase-report")
    public String theCreateForm(Model model) {
        if(adminSecurityService.isAuthenticated()) {
            model.addAttribute("dto", new GeneratePurchaseReportDto());
            return "admin_purchase_report";
        }
        return "redirect:/admin-login";

    }

}

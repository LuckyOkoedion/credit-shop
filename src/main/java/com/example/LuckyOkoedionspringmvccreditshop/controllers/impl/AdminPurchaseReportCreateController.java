package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.controllers.ICreateMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.entities.PurchaseEntity;
import com.example.LuckyOkoedionspringmvccreditshop.services.IPurchaseReportService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.PurchaseReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminPurchaseReportCreateController {

    private IPurchaseReportService purchaseReportService;

    public AdminPurchaseReportCreateController(PurchaseReportService thePurchaseReportService) {
        super();
        this.purchaseReportService = thePurchaseReportService;
    }

    @PostMapping("generate-purchase-report")
    public String create() {
        return "admin_purchase_report";
    }

    public String theCreateForm(Model model) {
        return "redirect:/admin";
    }


}

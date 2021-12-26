package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.controllers.ICreateMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.entities.PurchaseEntity;
import com.example.LuckyOkoedionspringmvccreditshop.services.IPurchaseService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.PurchaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerPurchaseCreateController implements ICreateMvcController {

    private IPurchaseService purchaseService;

    public CustomerPurchaseCreateController(PurchaseService thePurchaseService) {
        this.purchaseService = thePurchaseService;
    }

    @PostMapping("/purchase")
    @Override
    public <PurchaseEntity> String create( @ModelAttribute("student") PurchaseEntity modelAttribute) {
        return "payment_success_page";
    }

    @GetMapping("/checkout")
    @Override
    public String theCreateForm(Model model) {
        return "cart_checkout";
    }
}

package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.controllers.ICreateMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.entities.PurchaseEntity;
import com.example.LuckyOkoedionspringmvccreditshop.pojo.CartItemDto;
import com.example.LuckyOkoedionspringmvccreditshop.pojo.PurchaseDto;
import com.example.LuckyOkoedionspringmvccreditshop.services.IPurchaseService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.PurchaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerPurchaseCreateController implements ICreateMvcController<PurchaseDto> {

    private IPurchaseService purchaseService;

    public CustomerPurchaseCreateController(PurchaseService thePurchaseService) {
        this.purchaseService = thePurchaseService;
    }

    @PostMapping("/purchase-with-wallet")
    @Override
    public String create( @ModelAttribute("dto") PurchaseDto dto) {
        return "payment_success_page";
    }

    @PostMapping("/purchase-with-credit")
    public String creditPurchase(@ModelAttribute("dto") PurchaseDto dto) {
        return "payment_success_page";
    }

    @GetMapping("/checkout")
    @Override
    public String theCreateForm(Model model) {
        model.addAttribute("dto", new PurchaseDto());
        model.addAttribute("item", new CartItemDto());
        return "cart_checkout";
    }
}

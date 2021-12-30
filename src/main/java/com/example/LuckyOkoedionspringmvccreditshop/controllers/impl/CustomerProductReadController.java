package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.controllers.IReadMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.pojo.CartItemDto;
import com.example.LuckyOkoedionspringmvccreditshop.pojo.PurchaseDto;
import com.example.LuckyOkoedionspringmvccreditshop.services.IProductService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Locale;

@Controller
public class CustomerProductReadController {

    private IProductService productService;

    public CustomerProductReadController(ProductService theProductService) {
        super();
        this.productService = theProductService;
    }

    @GetMapping("/shop")
    public String getAll(Model model, Locale locale) {
        model.addAttribute("products", productService.getAll());
        model.addAttribute("purchase-dto", new PurchaseDto());
        return "shop_list";
    }

    @GetMapping("/shop/{id}")
    public String getOneById(@PathVariable Long id, Model model, @ModelAttribute("purchase-dto") PurchaseDto dto, Locale locale) {
        model.addAttribute("product", productService.getOneById(id));
        model.addAttribute("purchase-dto", dto);

        return "shop_detail";
    }
}

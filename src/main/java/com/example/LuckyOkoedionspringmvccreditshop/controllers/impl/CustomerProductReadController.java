package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.controllers.IReadMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.services.IProductService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CustomerProductReadController implements IReadMvcController {

    private IProductService productService;

    public CustomerProductReadController(ProductService theProductService) {
        super();
        this.productService = theProductService;
    }

    @GetMapping("/shop")
    @Override
    public String getAll(Model model) {
        return "shop_list";
    }

    @GetMapping("/shop/{id}")
    @Override
    public String getOneById(@PathVariable Long id, Model model) {
        return "shop_detail";
    }
}

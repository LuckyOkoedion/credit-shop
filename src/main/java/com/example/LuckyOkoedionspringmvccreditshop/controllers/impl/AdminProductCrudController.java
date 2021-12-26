package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.controllers.ICrudMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.entities.ProductEntity;
import com.example.LuckyOkoedionspringmvccreditshop.services.IProductService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminProductCrudController implements ICrudMvcController {

    private IProductService productService;

    public AdminProductCrudController(ProductService theProductService) {
        super();
        this.productService = theProductService;

    }

    @PostMapping("/add-product")
    @Override
    public <ProductEntity> String create( @ModelAttribute("product") ProductEntity modelAttribute) {
        return "redirect:/admin-products-list";
    }

    @GetMapping("/add-product")
    @Override
    public String theCreateForm(Model model) {
        return "admin_add_product";
    }

    @GetMapping("/admin-products-list")
    @Override
    public String getAll(Model model) {
        return "admin_products_list";
    }

    @Override
    public String getOneById(@PathVariable Long id, Model model) {
        return "redirect:/admin-products-list";
    }

    @GetMapping("edit-product/{id}")
    @Override
    public String theUpdateForm(@PathVariable Long id, Model model) {
        return "admin_product_edit";
    }

    @PostMapping("edit-product/{id}")
    @Override
    public <ProductEntity> String update(@PathVariable Long id, Model model, @ModelAttribute("product") ProductEntity modelAttribute) {
        return "redirect:/admin_products_list";
    }

    @Override
    public String delete(@PathVariable Long id) {
        return "redirect:/admin-products-list";
    }
}

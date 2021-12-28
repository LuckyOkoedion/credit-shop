package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.controllers.ICrudPictureMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.entities.ProductEntity;
import com.example.LuckyOkoedionspringmvccreditshop.pojo.FileResponse;
import com.example.LuckyOkoedionspringmvccreditshop.services.IProductService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.FileService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class AdminProductCrudController implements ICrudPictureMvcController<ProductEntity> {

    private IProductService productService;
    private FileService fileService;

    public AdminProductCrudController(ProductService theProductService) {
        super();
        this.productService = theProductService;

    }

    @PostMapping("/add-product")
    @Override
    public String create(@ModelAttribute("product") ProductEntity product, @RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) throws IOException {
        FileResponse uploadResult = fileService.save(file);
        product.setSource_image_id(uploadResult.getId());
        product.setPicture_url(uploadResult.getUrl());
        productService.create(product);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/admin-products-list";
    }

    @GetMapping("/add-product")
    @Override
    public String theCreateForm(Model model) {
        model.addAttribute("product", new ProductEntity());
        return "admin_add_product";

    }

    @GetMapping("/admin-products-list")
    @Override
    public String getAll(Model model) {
        model.addAttribute("products", productService.getAll());
        return "admin_products_list";
    }

    @Override
    public String getOneById(@PathVariable Long id, Model model) {
        return "redirect:/admin-products-list";
    }

    @GetMapping("/edit-product/{id}")
    @Override
    public String theUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getOneById(id));
        return "admin_product_edit";
    }

    @PostMapping("/edit-product/{id}")
    @Override
    public String update(@PathVariable Long id, Model model, @ModelAttribute("product") ProductEntity product,
            @RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) throws IOException {
        FileResponse uploadResult = fileService.save(file);
        product.setSource_image_id(uploadResult.getId());
        product.setPicture_url(uploadResult.getUrl());
        productService.update(product);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/admin-products-list";
    }

    @DeleteMapping("/delete-product/{id}")
    @Override
    public String delete(@PathVariable Long id) {
        productService.destroy(id);
        return "redirect:/admin-products-list";
    }
}

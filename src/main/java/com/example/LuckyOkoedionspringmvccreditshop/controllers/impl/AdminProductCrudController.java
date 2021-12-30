package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.entities.FileEntity;
import com.example.LuckyOkoedionspringmvccreditshop.entities.ProductEntity;
import com.example.LuckyOkoedionspringmvccreditshop.services.IFileCrudService;
import com.example.LuckyOkoedionspringmvccreditshop.services.IProductService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.FileCrudService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminProductCrudController {

    @Value("${uploadDir}")
    private String uploadFolder;

    private IProductService productService;
    private IFileCrudService fileService;

    public AdminProductCrudController(ProductService theProductService, FileCrudService theFileService
    ) {
        super();
        this.productService = theProductService;
        this.fileService = theFileService;

    }

    @PostMapping("/add-product")
    public String create(@ModelAttribute("product") ProductEntity product, @RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes, HttpServletRequest request) throws IOException {

        String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
        String fileName = file.getOriginalFilename();
        String filePath = Paths.get(uploadDirectory, fileName).toString();
        File dir = new File(uploadDirectory);

        if(!dir.exists()) {
            dir.mkdirs();
        }

        // Save the file locally
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
        stream.write(file.getBytes());
        stream.close();

        FileEntity dto = new FileEntity();
        dto.setContentType(file.getContentType());
        dto.setData(file.getBytes());
        dto.setName(file.getOriginalFilename());
        dto.setSize(file.getSize());
        FileEntity uploadResult = fileService.create(dto);
        product.setSource_image_id(uploadResult.getId());
        productService.create(product);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/admin-products-list";
    }

    @GetMapping("/add-product")
    public String theCreateForm(Model model) {
        model.addAttribute("product", new ProductEntity());
        return "admin_add_product";

    }

    @GetMapping("/admin-products-list")
    public String getAll(Model model) {
        model.addAttribute("products", productService.getAll());
        return "admin_products_list";
    }

    public String getOneById(@PathVariable Long id, Model model) {
        return "redirect:/admin-products-list";
    }

    @GetMapping("/edit-product/{id}")
    public String theUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getOneById(id));
        return "admin_product_edit";
    }

    @GetMapping("/show-product-image/{id}")
    @ResponseBody
    public void showImage(@PathVariable Long id, HttpServletResponse response, Optional<FileEntity> image) throws ServletException, IOException {
        image = Optional.ofNullable(fileService.getOneById(id));
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(image.get().getData());
        response.getOutputStream().close();
    }

    @PostMapping("/edit-product/{id}")
    public String update(@PathVariable Long id, Model model, @ModelAttribute("product") ProductEntity product,
            @RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) throws IOException {
        FileEntity dto = new FileEntity();
        dto.setContentType(file.getContentType());
        dto.setData(file.getBytes());
        dto.setName(file.getOriginalFilename());
        dto.setSize(file.getSize());
        FileEntity uploadResult = fileService.update(dto);
        product.setSource_image_id(uploadResult.getId());
        productService.update(product);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/admin-products-list";
    }

    @DeleteMapping("/delete-product/{id}")
    public String delete(@PathVariable Long id) {
        productService.destroy(id);
        return "redirect:/admin-products-list";
    }
}

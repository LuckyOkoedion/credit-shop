package com.example.LuckyOkoedionspringmvccreditshop.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

public interface ICrudPictureMvcController<E> {
    String create(E modelAttribute, @RequestParam("file") MultipartFile file,
                      RedirectAttributes redirectAttributes) throws IOException;
    String theCreateForm(Model model);
    String getAll(Model model);
    String getOneById(Long pathVarId, Model model);
    String theUpdateForm(Long pathVarId, Model model);
    String update(Long pathVarId, Model model, E modelAttribute, @RequestParam("file") MultipartFile file,
                      RedirectAttributes redirectAttributes) throws IOException;
    String delete(Long pathVarId);
}

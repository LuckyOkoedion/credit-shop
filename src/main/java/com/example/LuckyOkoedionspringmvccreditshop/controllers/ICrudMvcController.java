package com.example.LuckyOkoedionspringmvccreditshop.controllers;

import org.springframework.ui.Model;


public interface ICrudMvcController<E> {
    String create(E modelAttribute);
    String theCreateForm(Model model);
    String getAll(Model model);
    String getOneById(Long pathVarId, Model model);
    String theUpdateForm(Long pathVarId, Model model);
    String update(Long pathVarId, Model model, E modelAttribute);
    String delete(Long pathVarId);
}

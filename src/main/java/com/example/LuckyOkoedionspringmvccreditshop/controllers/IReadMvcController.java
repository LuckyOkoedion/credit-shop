package com.example.LuckyOkoedionspringmvccreditshop.controllers;

import org.springframework.ui.Model;

public interface IReadMvcController {
    String getAll(Model model);
    String getOneById(Long pathVarId, Model model);
}

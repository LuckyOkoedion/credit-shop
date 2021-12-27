package com.example.LuckyOkoedionspringmvccreditshop.controllers;

import org.springframework.ui.Model;

public interface ICreateMvcController<E> {
    String create(E modelAttribute);
    String theCreateForm(Model model);
}

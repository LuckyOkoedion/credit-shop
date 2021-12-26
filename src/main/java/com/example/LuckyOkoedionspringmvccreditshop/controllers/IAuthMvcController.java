package com.example.LuckyOkoedionspringmvccreditshop.controllers;

import org.springframework.ui.Model;

public interface IAuthMvcController {
    <E> String register(E modelAttribute);
    String theRegisterForm(Model model);
    <E> String login(E modelAttribute);
    String theLoginForm(Model model);
}

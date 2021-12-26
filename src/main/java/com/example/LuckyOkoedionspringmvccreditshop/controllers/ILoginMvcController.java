package com.example.LuckyOkoedionspringmvccreditshop.controllers;

import org.springframework.ui.Model;

public interface ILoginMvcController {
    <E> String login(E modelAttribute);
    String theLoginForm(Model model);
}

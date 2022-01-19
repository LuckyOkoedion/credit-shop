package com.example.LuckyOkoedionspringmvccreditshop;

public interface ISecurityService {
    boolean isAuthenticated();
    void login(String username, String password);
}

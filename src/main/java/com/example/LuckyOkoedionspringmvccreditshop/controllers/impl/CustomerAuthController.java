package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.ISecurityService;
import com.example.LuckyOkoedionspringmvccreditshop.SecurityService;
import com.example.LuckyOkoedionspringmvccreditshop.controllers.IAuthMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.entities.CreditEntity;
import com.example.LuckyOkoedionspringmvccreditshop.entities.CustomersEntity;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICustomerService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@Controller
public class CustomerAuthController implements IAuthMvcController<CustomersEntity> {

    private ICustomerService customerService;
    private ISecurityService securityService;

    public CustomerAuthController(CustomerService theCustomerService, SecurityService theSecurityService) {
        super();
        this.customerService = theCustomerService;
        this.securityService = theSecurityService;
    }

    @PostMapping("/register-customer")
    @Override
    public String register(@ModelAttribute("user") CustomersEntity user) {
        user.setWallet_ballance(new BigDecimal("0"));
        CustomersEntity customer = customerService.create(user);
        CreditEntity credit = new CreditEntity();
        credit.setCustomer(customer);
        credit.setAvailable_credit(new BigDecimal("0"));
        credit.setWallet_balance(new BigDecimal("0"));

        customerService.createCreditEntityForCustomer(customer.getId(), credit);
        return "redirect:/login-customer";
    }

    @GetMapping("/register-customer")
    @Override
    public String theRegisterForm(Model model) {
        model.addAttribute("user", new CustomersEntity());
        return "register_on_purchase";
    }

//    @PostMapping("/login-customer")
//    @Override
//    public String login(@ModelAttribute("user") CustomersEntity modelAttribute) {
//        return "redirect:/cart_checkout";
//    }

    // @PostMapping("/customer-logout")
    // @Override
    // public String logout(CustomersEntity modelAttribute) {
    // return "redirect:/shop";
    // }

    @GetMapping("/login-customer")
    @Override
    public String theLoginForm(Model model) {
        if(securityService.isAuthenticated()) {
            return "redirect:/shop";
        }
        return "login_customer_on_purchase";
    }
}

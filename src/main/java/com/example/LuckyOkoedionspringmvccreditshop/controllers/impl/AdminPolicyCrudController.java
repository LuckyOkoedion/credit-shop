package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.controllers.ICrudMvcController;
import com.example.LuckyOkoedionspringmvccreditshop.entities.CreditPolicyEntity;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICreditPolicyService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.CreditPolicyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminPolicyCrudController implements ICrudMvcController {

    private ICreditPolicyService creditPolicyService;

    public AdminPolicyCrudController(CreditPolicyService theCreditPolicyService) {
        super();
        this.creditPolicyService = theCreditPolicyService;
    }

    @PostMapping("/policy")
    @Override
    public <CreditPolicyEntity> String create(@ModelAttribute("credit-policy") CreditPolicyEntity modelAttribute) {
        return "redirect:/admin";
    }

    @GetMapping("/policy")
    @Override
    public String theCreateForm(Model model) {
        return "admin_setpolicy";
    }

    @Override
    public String getAll(Model model) {
        return "redirect:/admin";
    }

    @Override
    public String getOneById(@PathVariable Long id, Model model) {

        return "redirect:/admin";
    }

    @GetMapping("/policy-edit/{id}")
    @Override
    public String theUpdateForm(@PathVariable Long id, Model model) {
        return "admin_policy_edit";
    }

    @PostMapping("policy-edit/{id}")
    @Override
    public <CreditPolicyEntity> String update(@PathVariable Long id, Model model, @ModelAttribute("credit-policy") CreditPolicyEntity modelAttribute) {
        return "redirect:/admin";
    }

    @Override
    public String delete( @PathVariable Long id) {
        return "redirect:/admin";
    }
}

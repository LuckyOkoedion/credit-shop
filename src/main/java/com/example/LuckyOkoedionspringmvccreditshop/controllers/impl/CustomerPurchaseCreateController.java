package com.example.LuckyOkoedionspringmvccreditshop.controllers.impl;

import com.example.LuckyOkoedionspringmvccreditshop.ISecurityService;
import com.example.LuckyOkoedionspringmvccreditshop.SecurityService;
import com.example.LuckyOkoedionspringmvccreditshop.entities.CustomersEntity;
import com.example.LuckyOkoedionspringmvccreditshop.entities.ProductEntity;
import com.example.LuckyOkoedionspringmvccreditshop.entities.PurchaseEntity;
import com.example.LuckyOkoedionspringmvccreditshop.pojo.CartItemDto;
import com.example.LuckyOkoedionspringmvccreditshop.pojo.PaymentOption;
import com.example.LuckyOkoedionspringmvccreditshop.pojo.PurchaseDto;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICreditLimitValidatorService;
import com.example.LuckyOkoedionspringmvccreditshop.services.ICustomerService;
import com.example.LuckyOkoedionspringmvccreditshop.services.IPaymentMethodService;
import com.example.LuckyOkoedionspringmvccreditshop.services.IPurchaseService;
import com.example.LuckyOkoedionspringmvccreditshop.services.impl.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class CustomerPurchaseCreateController {

    private IPurchaseService purchaseService;
    private IPaymentMethodService payByWalletService;
    private IPaymentMethodService payByCreditService;
    private ICustomerService customerService;
    private ICreditLimitValidatorService creditLimitValidatorService;
    private ISecurityService securityService;

    public CustomerPurchaseCreateController(PurchaseService thePurchaseService,
            PaymentByCreditService payByCreditService, PaymentByWalletService payByWalletService,
            CustomerService customerService, CreditLimitValidatorService creditLimitValidatorService,
                                            SecurityService theSecurityService) {
        this.purchaseService = thePurchaseService;
        this.payByCreditService = payByCreditService;
        this.payByWalletService = payByWalletService;
        this.customerService = customerService;
        this.creditLimitValidatorService = creditLimitValidatorService;
        this.securityService = theSecurityService;
    }

    @PostMapping("customer/purchase-with-wallet")

    public String create(Model model, @ModelAttribute("purchase-dto") PurchaseDto dto,
            @ModelAttribute("payment_option") PaymentOption payment_option,
            @RequestParam("transaction_id") String transaction_id, RedirectAttributes redirectAttributes,
            Authentication auth) {
        model.addAttribute("purchase-dto", dto);
        PurchaseDto finalOrder = new PurchaseDto(transaction_id, dto.getProducts());
        String currentUserEmail = auth.getName();
        CustomersEntity currentUser = customerService.findByEmail(currentUserEmail);
        BigDecimal walletBallance = currentUser.getWallet_ballance();

        if (walletBallance.compareTo(finalOrder.getGrandtotal()) < 0) {
            // Insufficient funds
            redirectAttributes.addFlashAttribute("message",
                    "Insufficient Funds in the wallet !");
        } else {
            // Process payment
            payByWalletService.pay(finalOrder.getGrandtotal(), currentUser.getId(), transaction_id);
            // Record the purchase
            this.recordPurchase(finalOrder, transaction_id, currentUser, "wallet");
        }

        return "payment_success_page";
    }

    @PostMapping("/customer/purchase-with-credit")
    public String creditPurchase(Model model, @ModelAttribute("purchase-dto") PurchaseDto dto,
            @ModelAttribute("payment_option") PaymentOption payment_option,
            @RequestParam("transaction_id") String transaction_id, RedirectAttributes redirectAttributes,
            Authentication auth) {
        model.addAttribute("purchase-dto", dto);
        PurchaseDto finalOrder = new PurchaseDto(transaction_id, dto.getProducts());
        String currentUserEmail = auth.getName();
        CustomersEntity currentUser = customerService.findByEmail(currentUserEmail);
        Boolean sufficientFunds = creditLimitValidatorService.isThereSufficientCredit(finalOrder.getGrandtotal(),
                currentUser.getId());
        if (sufficientFunds) {
            // Process payment
            payByCreditService.pay(finalOrder.getGrandtotal(), currentUser.getId(), transaction_id);
            // Record the purchase
            this.recordPurchase(finalOrder, transaction_id, currentUser, "credit");

        } else {
            redirectAttributes.addFlashAttribute("message",
                    "Insufficient Funds in your credit account !");
        }

        return "payment_success_page";
    }

    @GetMapping("/checkout")
    public String theCreateForm(Model model, @ModelAttribute("purchase-dto") PurchaseDto dto) {
        if (securityService.isAuthenticated()) {
            model.addAttribute("purchase-dto", dto);
            Integer cart_size = dto.getProducts().size();
            List<CartItemDto> cart_items = dto.getProducts();
            model.addAttribute("cart_items", cart_items);
            model.addAttribute("cart_size", cart_size);
            model.addAttribute("payment_option", new PaymentOption());
            return "cart_checkout";
        }
        return "redirect:/login-customer";

    }


    @PostMapping("/add-product-to-cart")
    public String addToCart(Model model, @ModelAttribute("product") ProductEntity product,
            @ModelAttribute("purchase-dto") PurchaseDto dto,
            @ModelAttribute("payment_option") PaymentOption payment_option,
            @RequestParam("quantity") Integer quantity) {
        CartItemDto theItem = new CartItemDto(product, quantity);
        dto.addProducts(theItem);
        model.addAttribute("purchase-dto", dto);
        Integer cart_size = dto.getProducts().size();
        List<CartItemDto> cart_items = dto.getProducts();
        model.addAttribute("cart_items", cart_items);
        model.addAttribute("cart_size", cart_size);
        model.addAttribute("payment_option", payment_option);

        return "cart_checkout";

    }

    private void recordPurchase(PurchaseDto thePurchaseDto, String transaction_id, CustomersEntity theCustomer,
            String payment_method) {
        List<CartItemDto> products = thePurchaseDto.getProducts();

        for (CartItemDto item : products) {
            PurchaseEntity purchase = new PurchaseEntity();
            purchase.setProduct(item.getProduct());
            purchase.setCustomer(theCustomer);
            purchase.setDate(new java.sql.Date(new java.util.Date().getTime()));
            purchase.setPaid_by_credit_or_wallet(payment_method);
            purchase.setTransaction_id(transaction_id);
            purchaseService.create(purchase);

        }

    }
}

package com.example.LuckyOkoedionspringmvccreditshop.entities;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class CustomersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column
    private String credit_card_number;
    @Column
    private String credit_card_type;
    @Column
    private BigDecimal wallet_ballance;
    @Column
    private String credit_card_bank;
    @Column
    private String credit_card_expiration;
    @OneToOne(mappedBy = "cutomer", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CreditEntity credit;
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<WalletDepositsEntity> wallet_deposits = new ArrayList<>();
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<WalletWithdrawalsEntity> wallet_withdrawals = new ArrayList<>();
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PurchaseEntity> purchase = new ArrayList<>();


    public  CustomersEntity() {

    }


    public  CustomersEntity(  String first_name, String last_name, String email, String password, String credit_card_number, String credit_card_type, String credit_card_bank, String credit_card_expiration, CreditEntity credit, List<WalletDepositsEntity> wallet_deposits, List<WalletWithdrawalsEntity> wallet_withdrawals, List<PurchaseEntity> purchase, BigDecimal wallet_ballance) {
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.credit_card_number = credit_card_number;
        this.credit_card_type = credit_card_type;
        this.credit_card_bank = credit_card_bank;
        this.credit_card_expiration = credit_card_expiration;
        this.credit = credit;
        this.wallet_deposits = wallet_deposits;
        this.wallet_withdrawals = wallet_withdrawals;
        this.purchase = purchase;
        this.wallet_ballance = wallet_ballance;
    }

    public void addWallet_deposits(WalletDepositsEntity wallet_deposit) {
        wallet_deposits.add(wallet_deposit);
        wallet_deposit.setCustomer(this);
    }

    public void removeWallet_deposits(WalletDepositsEntity wallet_deposit) {
        wallet_deposits.remove(wallet_deposit);
        wallet_deposit.setCustomer(null);
    }

    public void addPurchase(PurchaseEntity thePurchase) {
        purchase.add(thePurchase);
        thePurchase.setCustomer(this);
    }

    public void removePurchase(PurchaseEntity thePurchase) {
        purchase.remove(thePurchase);
        thePurchase.setCustomer(null);
    }

    public void addWallet_withdrawals(WalletWithdrawalsEntity wallet_withdrawal) {
        wallet_withdrawals.add(wallet_withdrawal);
        wallet_withdrawal.setCustomer(this);
    }

    public void removeWallet_withdrawals(WalletWithdrawalsEntity wallet_withdrawal) {
        wallet_deposits.remove(wallet_withdrawal);
        wallet_withdrawal.setCustomer(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCredit_card_number() {
        return credit_card_number;
    }

    public void setCredit_card_number(String credit_card_number) {
        this.credit_card_number = credit_card_number;
    }

    public String getCredit_card_type() {
        return credit_card_type;
    }

    public void setCredit_card_type(String credit_card_type) {
        this.credit_card_type = credit_card_type;
    }

    public String getCredit_card_bank() {
        return credit_card_bank;
    }

    public void setCredit_card_bank(String credit_card_bank) {
        this.credit_card_bank = credit_card_bank;
    }

    public String getCredit_card_expiration() {
        return credit_card_expiration;
    }

    public void setCredit_card_expiration(String credit_card_expiration) {
        this.credit_card_expiration = credit_card_expiration;
    }

    public CreditEntity getCredit() {
        return credit;
    }

    public void setCredit(CreditEntity credit) {
        this.credit = credit;
    }

    public List<WalletDepositsEntity> getWallet_deposits() {
        return wallet_deposits;
    }

    public void setWallet_deposits(List<WalletDepositsEntity> wallet_deposits) {
        this.wallet_deposits = wallet_deposits;
    }

    public List<WalletWithdrawalsEntity> getWallet_withdrawals() {
        return wallet_withdrawals;
    }

    public void setWallet_withdrawals(List<WalletWithdrawalsEntity> wallet_withdrawals) {
        this.wallet_withdrawals = wallet_withdrawals;
    }

    public List<PurchaseEntity> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<PurchaseEntity> purchase) {
        this.purchase = purchase;
    }

    public BigDecimal getWallet_ballance() {
        return wallet_ballance;
    }

    public void setWallet_ballance(BigDecimal wallet_ballance) {
        this.wallet_ballance = wallet_ballance;
    }
}

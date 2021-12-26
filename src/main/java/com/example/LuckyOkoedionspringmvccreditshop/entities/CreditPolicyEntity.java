package com.example.LuckyOkoedionspringmvccreditshop.entities;

import javax.persistence.*;

@Entity
@Table
public class CreditPolicyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String reset_when;

    @Column
    private String reload_when;

    @Column
    private String credit_limit;

    public CreditPolicyEntity() {

    }

    public CreditPolicyEntity(String reset_when, String reload_when, String credit_limit) {
        super();
        this.credit_limit = credit_limit;
        this.reload_when = reload_when;
        this.reset_when = reset_when;
    }

    public Long getId() {
        return id;
    }

    public String getReset_when() {
        return reset_when;
    }

    public String getReload_when() {
        return reload_when;
    }

    public String getCredit_limit() {
        return credit_limit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReset_when(String reset_when) {
        this.reset_when = reset_when;
    }

    public void setReload_when(String reload_when) {
        this.reload_when = reload_when;
    }

    public void setCredit_limit(String credit_limit) {
        this.credit_limit = credit_limit;
    }
}

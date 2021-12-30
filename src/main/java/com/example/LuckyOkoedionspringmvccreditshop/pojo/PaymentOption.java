package com.example.LuckyOkoedionspringmvccreditshop.pojo;

public class PaymentOption {
    private PaymentMethodEnum method;
    private int option_id;

    public PaymentOption() {

    }

    public PaymentMethodEnum getMethod() {
        return method;
    }

    public void setMethod(PaymentMethodEnum method) {
        this.method = method;
    }

    public int getOption_id() {
        return option_id;
    }

    public void setOption_id(int option_id) {
        this.option_id = option_id;
    }


}

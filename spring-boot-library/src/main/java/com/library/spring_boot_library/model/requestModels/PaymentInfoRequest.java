package com.library.spring_boot_library.model.requestModels;

public class PaymentInfoRequest {
    private int amount;

    private String currency;

    private String receiptEmail;

    public int getAmount() {
        return amount;
    }

    public PaymentInfoRequest setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public PaymentInfoRequest setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getReceiptEmail() {
        return receiptEmail;
    }

    public PaymentInfoRequest setReceiptEmail(String receiptEmail) {
        this.receiptEmail = receiptEmail;
        return this;
    }
}

package com.bl.enums;

public enum TransactionType {

    SEND("Send"),
    RECEIVE("Receive");

    private String text;

    TransactionType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

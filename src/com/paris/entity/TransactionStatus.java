package com.paris.entity;

public class TransactionStatus {


    private Double id;
    private String status;
    private Integer value;

    public Double getId() {
        return id;
    }

    public TransactionStatus setId(Double id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TransactionStatus setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public TransactionStatus setValue(Integer value) {
        this.value = value;
        return this;
    }
}

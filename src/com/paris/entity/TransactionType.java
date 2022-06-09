package com.paris.entity;

public class TransactionType {
    private Double id;
    private String type;
    private Integer value;

    public Double getId() {
        return id;
    }

    public TransactionType setId(Double id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public TransactionType setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public TransactionType setValue(Integer value) {
        this.value = value;
        return this;
    }
}

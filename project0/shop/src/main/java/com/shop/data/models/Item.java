package com.shop.data.models;

public class Item {
    private int id;
    private String name;
    private double price;
    private int ownerId;
    private int remainingPayments;
    private double balance;
    private int offerId;

    @Override
    public String toString() {
        return "Purchase Id: " + id + " Name: " + name + " Sticker price: $" + price + " Remaining payments: "
                + remainingPayments + " Balance: $" + String.format("%.2f", balance);
    }

    public Item(int id, String name, double price, int remainingPayments, double balance) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.remainingPayments = remainingPayments;
        this.balance = balance;
    }

    public Item(int id, String name, double price, int ownerId, int remainingPayments, double balance, int offerId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ownerId = ownerId;
        this.remainingPayments = remainingPayments;
        this.balance = balance;
        this.offerId = offerId;
    }

    public Item(int id) {
        this.id = id;
    }

    public Item() {

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getRemainingPayments() {
        return remainingPayments;
    }

    public void setRemainingPayments(int remainingPayments) {
        this.remainingPayments = remainingPayments;
    }

}

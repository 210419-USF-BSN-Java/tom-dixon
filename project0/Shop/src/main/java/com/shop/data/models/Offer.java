package com.shop.data.models;

public class Offer {
    private int id;
    private int itemId;
    private double downPayment;
    private int weeks;
    private double paymentPerWeek;

    public Offer() {

    }

    public Offer(int itemId, double deposit, int weeks, double paymentPerWeek, int custId, double gross) {
        this.itemId = itemId;
        this.downPayment = deposit;
        this.weeks = weeks;
        this.paymentPerWeek = paymentPerWeek;
        this.custId = custId;
        this.gross = gross;
    }

    public Offer(int id, int itemId, double downPayment, int weeks, double paymentPerWeek, int custId, boolean pending,
            double gross) {
        this.id = id;
        this.itemId = itemId;
        this.downPayment = downPayment;
        this.weeks = weeks;
        this.custId = custId;
        this.pending = pending;
        this.gross = gross;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public double getPaymentPerWeek() {
        return paymentPerWeek;
    }

    public void setPaymentPerWeek(double paymentPerWeek) {
        this.paymentPerWeek = paymentPerWeek;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    private int custId;
    private boolean pending;
    private double gross;

}

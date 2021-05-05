package com.shop.data.models;

public class Payment {
    @Override
	public String toString() {
		return "Payment Id: " + id + ", Item Id: " + itemId + " Offer Id: " + offerId + " User Id: " + userId;
	}

	int id;
    int itemId;
    int offerId;
    int userId;

    public Payment() {

    }

    public Payment(int id) {
        this.id = id;
    }

    public Payment(int itemId, int offerId, int userId) {
        this.itemId = itemId;
        this.offerId = offerId;
        this.userId = userId;
    }

    public Payment(int id, int itemId, int offerId, int userId) {
        this.id = id;
        this.itemId = itemId;
        this.offerId = offerId;
        this.userId = userId;
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

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

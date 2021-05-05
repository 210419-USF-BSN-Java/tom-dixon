package com.shop.services;

import java.util.List;

import com.shop.data.daos.ItemsDao;
import com.shop.data.daos.OffersDao;
import com.shop.data.daos.PaymentsDao;
import com.shop.data.models.Item;
import com.shop.data.models.Offer;
import com.shop.data.models.Payment;
import com.shop.data.models.User;

public class PaymentsService {
    ItemsDao iDao;
    PaymentsDao pDao;
    OffersDao oDao;

    public PaymentsService(ItemsDao iDao, PaymentsDao pDao, OffersDao oDao) {
        this.iDao = iDao;
        this.pDao = pDao;
        this.oDao = oDao;
    }

    public int processPayment(Item item, User u) {
        int result = 0;

        item.toString();
        u.toString();

        // add payment and increment result
        result += pDao.add(new Payment(item.getId(), item.getOfferId(), u.getId()));

        // retrieve weekly payment amount from offer
        Offer offer = oDao.get(item.getOfferId());

        // System.out.println(offer.getPaymentPerWeek());

        // update item. decrement remaining_payment and subtract payment from balance
        item.setBalance(item.getBalance() - offer.getPaymentPerWeek());
        item.setRemainingPayments(item.getRemainingPayments() - 1);

        result += iDao.update(item);

        return result;
        
    }

    public List<Payment> getPayments() {
    
        return pDao.getAll();
        
    }

}

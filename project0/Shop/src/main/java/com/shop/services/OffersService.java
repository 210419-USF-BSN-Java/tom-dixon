package com.shop.services;

import java.util.List;

import com.shop.data.daos.OffersDao;
import com.shop.data.models.Item;
import com.shop.data.models.Offer;

public class OffersService {
    private OffersDao oDao;

    public OffersService(OffersDao oDao) {
        this.oDao = oDao;
    }

    public int addOffer(Offer o) {
        return oDao.add(o);
    }

    public List<Offer> getOffers() {
        return oDao.getAll();
    }

    public int approve(Offer o) {
        return oDao.approve(o);
    }

    public int rejectOffersByItem(Item i) {
        return oDao.rejectOfferByItem(i);
    }
    // public int deleteOffersByItem(Item i) {
    // return oDao.deleteByItem(i);
    // }
}

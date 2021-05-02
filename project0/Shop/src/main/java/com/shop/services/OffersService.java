package com.shop.services;

import com.shop.data.daos.OffersDao;
import com.shop.data.models.Offer;

public class OffersService {
    private OffersDao oDao;

    public OffersService(OffersDao oDao) {
        this.oDao = oDao;
    }

    public int addOffer(Offer o) {
        return oDao.add(o);
    }

}

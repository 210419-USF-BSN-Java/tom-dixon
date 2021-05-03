package com.shop.services;

import java.util.List;

import com.shop.data.daos.ItemsDao;
import com.shop.data.models.Item;
import com.shop.data.models.Offer;
import com.shop.data.models.User;

public class ItemsService {
    private ItemsDao iDao;

    public ItemsService(ItemsDao iDao) {
        this.iDao = iDao;
    }

    public List<Item> getAllItems() {
        return iDao.getAll();
    }

    public int addNewItem(Item i) {
        return iDao.add(i);
    }

    public int removeItemById(Item i) {
        return iDao.remove(i);
    }

    public int assignOwnership(Item item, Offer offer) {
        // item id (id) = i.getId()
        // owned_by = u.getId()
        // remaining payments = o.getWeeks()
        // balance = o.getGross()
        return iDao.assignOwnership(item, offer);
    }

}

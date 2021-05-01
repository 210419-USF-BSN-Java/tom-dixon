package com.shop.services;

import com.shop.data.daos.ItemsDao;
import com.shop.data.models.Item;

public class ItemsService {
    private ItemsDao iDao;

    public ItemsService(ItemsDao iDao) {
        this.iDao = iDao;
    }

    public int addNewItem(Item i) {

        return iDao.add(i);
    }

}

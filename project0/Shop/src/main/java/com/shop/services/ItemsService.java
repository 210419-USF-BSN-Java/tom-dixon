package com.shop.services;

import java.util.List;

import com.shop.data.daos.ItemsDao;
import com.shop.data.models.Item;

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

}

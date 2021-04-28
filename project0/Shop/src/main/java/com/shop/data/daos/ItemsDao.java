package com.shop.data.daos;

import com.shop.data.daos.GenericDao;
import com.shop.data.models.Item;

public interface ItemsDao extends GenericDao<Item> {
	// CRUD operations
	int add(Item i);

	Item get(int i);

	public Item update(int id, Item item);

	int remove(Item i);
}

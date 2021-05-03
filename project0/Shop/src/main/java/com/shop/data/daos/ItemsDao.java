package com.shop.data.daos;

import com.shop.data.models.Item;
import com.shop.data.models.Offer;
import com.shop.data.models.User;

public interface ItemsDao extends GenericDao<Item> {
	// CRUD operations
	int add(Item i);

	Item get(int i);

	public Item update(int id, Item item);

	int remove(Item i);

	int assignOwnership(Item item, Offer offer);
}

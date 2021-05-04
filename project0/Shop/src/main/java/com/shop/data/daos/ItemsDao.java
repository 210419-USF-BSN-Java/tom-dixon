package com.shop.data.daos;

import java.util.List;

import com.shop.data.models.Item;
import com.shop.data.models.Offer;
import com.shop.data.models.User;

public interface ItemsDao extends GenericDao<Item> {
	// CRUD operations
	int add(Item i);

	List<Item> getAll();

	List<Item> getAllUnowned();

	List<Item> getOwnersItems(User u);

	Item get(int i);

	public int update(int id, Item item);

	int remove(Item i);

	int assignOwnership(Item item, Offer offer);
}

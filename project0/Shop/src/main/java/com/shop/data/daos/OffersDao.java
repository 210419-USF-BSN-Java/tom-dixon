package com.shop.data.daos;
import com.shop.data.models.Offer;

public interface OffersDao extends GenericDao<Offer> {
	int add(Offer c);

	Offer get(int i);

	Offer update(int id, Offer c);

	int remove(Offer c);

}

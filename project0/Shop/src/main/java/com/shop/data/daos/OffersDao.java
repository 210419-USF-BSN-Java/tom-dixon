package com.shop.data.daos;
import com.shop.data.models.Offer;

public interface OffersDao extends GenericDao<Offer> {
	Offer add(Offer c);

	Offer get(int i);

	Offer update(int id, Offer c);

	Integer remove(Offer c);

}

package com.shop.data;

import com.shop.models.Offer;

public interface OffersDao extends GenericDao<Object> {
	Offer add(Offer c);

	Offer get(int i);

	Offer update(int id, Offer c);

	Integer remove(Offer c);

}

package com.cart.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShopProductService {
	private ShopProductDAOInterface dao;
	
	public ShopProductService() {
		dao = new ShopProductJDBCDAO();
	}

	public List<Map<String, Object>> getAll() {
		return dao.getAll();
	}
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
		return dao.getCartProducts(cartList);
	}
	
	public Integer getTotalCartPrice(ArrayList<Cart> cartList) {
		return dao.getTotalCartPrice(cartList);
	}
}

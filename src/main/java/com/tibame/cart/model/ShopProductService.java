package com.tibame.cart.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopProductService {
//	@Autowired
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

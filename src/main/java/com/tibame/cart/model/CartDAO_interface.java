package com.tibame.cart.model;

import java.util.List;

public interface CartDAO_interface {
	public void insert(CartVO cartVO);
    public void update(CartVO cartVO);
    public void delete(Integer cartNo);
    public CartVO findByPrimaryKey(Integer cartNo);
    public List<CartVO> getAll();
}

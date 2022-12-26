package com.tibame.cart.model;

import java.util.List;


public class CartService {
	private CartDAO_interface dao;

	public CartService() {
		dao = new CartJDBCDAO();
	}

	public CartVO addCart(Integer memberNo, Integer productNo, Integer qty) {

		CartVO cartVO = new CartVO();

		cartVO.setMemberNo(memberNo);
		cartVO.setProductNo(productNo);
		cartVO.setQty(qty);
		dao.insert(cartVO);

		return cartVO;

	}

	public CartVO updateCart(Integer cartNo, Integer memberNo, Integer productNo, Integer qty) {

		CartVO cartVO = new CartVO();

		cartVO.setCartNo(cartNo);
		cartVO.setMemberNo(memberNo);
		cartVO.setProductNo(productNo);
		cartVO.setQty(qty);
		dao.update(cartVO);

		return cartVO;
	}

	public void deleteCart(Integer cartNo) {
		dao.delete(cartNo);
	}

	public CartVO getOneCart(Integer cartNo) {
		return dao.findByPrimaryKey(cartNo);
	}

	public List<CartVO> getAll() {
		return dao.getAll();
	}
}

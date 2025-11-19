package com.study.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.shop.domain.Cart;
import com.study.shop.repository.CartRepositroy;

@Service
public class CartService {
	
	@Autowired
	CartRepositroy cartRepository;
	
	public Cart addCart(Cart cart) {
		Optional<Cart> result = cartRepository.findById(cart.getId());
		if(result.isPresent()) {
			Cart resultCart = result.get();
			resultCart.setCount(resultCart.getCount() + cart.getCount());
			return cartRepository.save(resultCart);
		} else {
			return cartRepository.save(cart);
		}
	}

	public List<Cart> getCart(String memId) {
		return cartRepository.findByMemIdOrderById(memId);
	}
}
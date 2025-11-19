package com.study.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.shop.domain.Cart;
import com.study.shop.service.CartService;

@RestController
@RequestMapping("/react")
public class CartController {

	@Autowired
	CartService cartService;
	
	@PostMapping("/addCart")
	public String addCart(@RequestBody Cart cart) {
		System.out.println(cart.getMemId());
		Cart result = cartService.addCart(cart);
		return "OK";
	}
	
	@GetMapping("/getCart")
	public List<Cart> getCart(@RequestParam(value="memId") String memId){
		System.out.println(memId);
		return cartService.getCart(memId);
	}
}

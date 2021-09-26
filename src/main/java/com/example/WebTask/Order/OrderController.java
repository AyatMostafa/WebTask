package com.example.WebTask.Order;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.stripe.exception.StripeException;


@RestController
@RequestMapping(path = "/order/checkout")
public class OrderController {
	
	@Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;
	
	private final OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	public String checkout(@RequestBody Order orderForm) throws StripeException {
		boolean result1 = orderService.validateItemsExistence(orderForm.getItems());
		System.out.println(result1);
		float price = orderService.validateTotalPrice(orderForm.getItems());
		System.out.println(price);
		boolean result = orderService.chargeNewCard(orderForm.getCreditCard(), price);
		if( result)
			return "Succeed";
		else
			return "Failed";
	}
}

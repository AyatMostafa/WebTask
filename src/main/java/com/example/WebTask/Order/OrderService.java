package com.example.WebTask.Order;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Service
public class OrderService {

	@Autowired
	private ItemRepository itemRepo;
	
	@Value("${STRIPE_SECRET_KEY}")
    private String API_SECRET_KEY;
	
	
	
	public OrderService(ItemRepository itemRepo) {
		Stripe.apiKey = API_SECRET_KEY;
	}

	public boolean validateItemsExistence(List<String> items) {
		List<Item> itemsByName = itemRepo.findByNames(items);
		for(Item item : itemsByName)
		{
			if(!item.isAvailable()) {
//				throw new IllegalStateException("The item of name '" + itemByName.getname() + "' is not avaliable");
				return false;
			}
		}
		return true;
	}

	public float validateTotalPrice(List<String> items) {
		float totalPrice = 0;
		List<Item> itemsByName = itemRepo.findByNames(items);
		for(Item item : itemsByName)
		{
			totalPrice += item.getPrice();
		}
		if(totalPrice < 100)
			throw new IllegalStateException("the total basket money value is below 100");
		if(totalPrice > 1500)
			throw new IllegalStateException("May the user is fraud");
		
		return totalPrice;
	}

	public Boolean chargeNewCard(String creditCard, float price) throws StripeException {
		Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", (int)(price * 100));
        chargeParams.put("currency", "USD");
        chargeParams.put("source", creditCard);
        Charge charge = Charge.create(chargeParams);
        return charge.getPaid();
	}
	
}
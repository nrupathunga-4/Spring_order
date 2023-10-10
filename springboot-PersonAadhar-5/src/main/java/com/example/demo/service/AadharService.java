package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundExcpetion;
import com.example.demo.model.AadharCard;
import com.example.demo.model.Orders;
import com.example.demo.model.Products;
import com.example.demo.repository.AadharRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class AadharService {

	@Autowired
	private  PersonRepository personRepository;
	
	@Autowired
	private AadharRepository aadharRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	public AadharCard saveAadhar(AadharCard aadharCard)
	{
		return aadharRepository.save(aadharCard);
	}
	
	public  Optional<AadharCard> getPersonByAdharnumber(String adharnumber)
	{
		return aadharRepository.findByAdharnumber(adharnumber);
	}
	
	public AadharCard updateAadhar(AadharCard aadharCard,String adharnumber) throws UserNotFoundExcpetion
	{
	  AadharCard aadharCard2=aadharRepository.findByAdharnumber(adharnumber).orElseThrow(()->new UserNotFoundExcpetion("User Doesn't Exist in Database"));
	  aadharCard2.setAdharaadress(aadharCard.getAdharaadress());
	   
	  aadharRepository.save(aadharCard2);
	  return aadharCard2;
	}
	
	public void deleteAadhar(String aadharnumber) throws UserNotFoundExcpetion
	{
		aadharRepository.findByAdharnumber(aadharnumber).orElseThrow(()->new UserNotFoundExcpetion("user Doesn't Exist in the Database"));
		aadharRepository.deleteById(aadharnumber);
	}
	
	public Orders saveOrder(Orders orders)
	{
		return orderRepository.save(orders);
	}
	
	public Orders getOrderBuId(long orderid) throws UserNotFoundExcpetion
	{
		 return orderRepository.findById(orderid).orElseThrow(()->new UserNotFoundExcpetion("Order Doesn't exist in Database"));
	}
	
	public Orders updateOrders(Orders orders,long orderid) throws UserNotFoundExcpetion
	{
		Orders orders2=orderRepository.findById(orderid).orElseThrow(()->new UserNotFoundExcpetion("Order Doesn't Exist In database"));
		orders2.setShippingaddress(orders.getShippingaddress());
		orders2.setTrackingid(orders.getTrackingid());
		
		orderRepository.save(orders2);
		return orders2;
	}
	
	public void deleteOrder(long orderid) throws UserNotFoundExcpetion
	{
		orderRepository.findById(orderid).orElseThrow(()->new UserNotFoundExcpetion("Order Doesn't Exist in Database"));
		orderRepository.deleteById(orderid);
	}
	
}
